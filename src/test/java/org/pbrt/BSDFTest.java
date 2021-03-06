/*
 * PBrtJ -- Port of pbrt v3 to Java.
 * Copyright (c) 2017 Rick Weyrauch.
 *
 * pbrt source code is Copyright(c) 1998-2016
 * Matt Pharr, Greg Humphreys, and Wenzel Jakob.
 *
 */
package org.pbrt;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.pbrt.core.Api;
import org.pbrt.core.Options;
import org.pbrt.core.BSDF;
import org.pbrt.core.BxDF;
import org.pbrt.core.ParamSet;
import org.pbrt.core.Pbrt;
import org.pbrt.core.Point2f;
import org.pbrt.core.Point3f;
import org.pbrt.core.RNG;
import org.pbrt.core.Ray;
import org.pbrt.core.Sampling;
import org.pbrt.core.Shape;
import org.pbrt.core.Spectrum;
import org.pbrt.core.SurfaceInteraction;
import org.pbrt.core.Transform;
import org.pbrt.core.Vector3f;
import org.pbrt.shapes.Disk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.commons.math3.special.Gamma;

public class BSDFTest {

    /* The null hypothesis will be rejected when the associated
       p-value is below the significance level specified here. */
    private static final float CHI2_SLEVEL = 0.01f;

    /* Resolution of the frequency table discretization. The azimuthal
       resolution is twice this value. */
    private static final int CHI2_THETA_RES = 10;
    private static final int CHI2_PHI_RES = 2 * CHI2_THETA_RES;

    /* Number of MC samples to compute the observed frequency table */
    private static final int CHI2_SAMPLECOUNT = 1000000;

    /* Minimum expected bin frequency. The chi^2 test does not
       work reliably when the expected frequency in a cell is
       low (e.g. less than 5), because normality assumptions
       break down in this case. Therefore, the implementation
       will merge such low-frequency cells when they fall below
       the threshold specified here. */
    private static final int CHI2_MINFREQ = 5;

    /* Each provided BSDF will be tested for a few different
       incident directions. The value specified here determines
       how many tests will be executed per BSDF */
    private static final int CHI2_RUNS = 5;

    /// Regularized lower incomplete gamma function (based on code from Cephes)
    private static double RLGamma(final double a, final double x) throws Exception {
        final double epsilon = 0.000000000000001;
        final double big = 4503599627370496.0;
        final double bigInv = 2.22044604925031308085e-16;
        if (a < 0 || x < 0)
            throw new Exception("LLGamma: invalid arguments range!");

        if (x == 0)
            return 0.0;

        final double ax = (a * Math.log(x)) - x - Gamma.logGamma(a);
        if (ax < -709.78271289338399)
            return a < x ? 1.0 : 0.0;

        if (x <= 1 || x <= a) {
            double r2 = a;
            double c2 = 1;
            double ans2 = 1;

            while ((c2 / ans2) > epsilon) {
                r2 = r2 + 1;
                c2 = c2 * x / r2;
                ans2 += c2;
            }

            return Math.exp(ax) * ans2 / a;
        }

        int c = 0;
        double y = 1 - a;
        double z = x + y + 1;
        double p3 = 1;
        double q3 = x;
        double p2 = x + 1;
        double q2 = z * x;
        double ans = p2 / q2;
        double error = 1;

        while (error > epsilon) {
            c++;
            y += 1;
            z += 2;
            final double yc = y * c;
            final double p = (p2 * z) - (p3 * yc);
            final double q = (q2 * z) - (q3 * yc);

            if (q != 0) {
                final double nextans = p / q;
                error = Math.abs((ans - nextans) / nextans);
                ans = nextans;
            } else {
                // zero div, skip
                error = 1;
            }

            // shift
            p3 = p2;
            p2 = p;
            q3 = q2;
            q2 = q;

            // normalize fraction when the numerator becomes large
            if (Math.abs(p) > big) {
                p3 *= bigInv;
                p2 *= bigInv;
                q3 *= bigInv;
                q2 *= bigInv;
            }
        }

        return 1.0 - (Math.exp(ax) * ans);
    }

    /// Chi^2 distribution cumulative distribution function
    private static double Chi2CDF(final double x, final int dof) throws Exception {
        if (dof < 1 || x < 0) {
            return 0.0;
        } else if (dof == 2) {
            return 1.0 - Math.exp(-0.5 * x);
        } else {
            return RLGamma(0.5 * dof, 0.5 * x);
        }
    }

    /// Generate a histogram of the BSDF density function via MC sampling
    private static void FrequencyTable(final BSDF bsdf, final Vector3f wo, final RNG rng, final int sampleCount,
            final int thetaRes, final int phiRes, final float[] target) {

        for (int i = 0; i < target.length; i++)
            target[i] = 0;

        final float factorTheta = thetaRes / Pbrt.Pi, factorPhi = phiRes / (2 * Pbrt.Pi);

        int flags;
        Vector3f wi;
        float pdf;

        for (int i = 0; i < sampleCount; ++i) {
            final Point2f sample = new Point2f(rng.UniformFloat(), rng.UniformFloat());
            final var sf = bsdf.Sample_f(wo, sample, BxDF.BSDF_ALL);
            final Spectrum f = sf.f;
            flags = sf.sampledType;
            wi = sf.wiWorld;
            pdf = sf.pdf;

            if (f.isBlack() || ((flags & BxDF.BSDF_SPECULAR) != 0))
                continue;

            final Vector3f wiL = bsdf.WorldToLocal(wi);

            final Point2f coords = new Point2f((float) Math.acos(Pbrt.Clamp(wiL.z, -1, 1)) * factorTheta,
                    (float) Math.atan2(wiL.y, wiL.x) * factorPhi);

            if (coords.y < 0)
                coords.y += 2 * Pbrt.Pi * factorPhi;

            final int thetaBin = (int) Math.min(Math.max(0, Math.floor(coords.x)), thetaRes - 1);
            final int phiBin = (int) Math.min(Math.max(0, Math.floor(coords.y)), phiRes - 1);

            target[thetaBin * phiRes + phiBin] += 1;
        }
    }

    /* Define an recursive function for integration over subintervals */
    private static float integrate(final Function<Float, Float> func, final float a, final float b, final float c, final float fa, final float fb,
            final float fc, final float I, final float eps, final int depth) {
        /* Evaluate the function at two intermediate points */
        final float d = 0.5f * (a + b), e = 0.5f * (b + c);
        final float fd = func.apply(d);
        final float fe = func.apply(e);

        /* Simpson integration over each subinterval */
        final float h = c - a, I0 = (float) (1.0 / 12.0) * h * (fa + 4 * fd + fb),
                I1 = (float) (1.0 / 12.0) * h * (fb + 4 * fe + fc), Ip = I0 + I1;
        // ++count;

        /*
         * Stopping criterion from J.N. Lyness (1969)
         * "Notes on the adaptive Simpson quadrature routine"
         */
        if (depth <= 0 || Math.abs(Ip - I) < 15 * eps) {
            // Richardson extrapolation
            return Ip + (float) (1.0 / 15.0) * (Ip - I);
        }

        return integrate(func, a, d, b, fa, fd, fb, I0, 0.5f * eps, depth - 1)
                + integrate(func, b, e, c, fb, fe, fc, I1, 0.5f * eps, depth - 1);
    }

    /// Adaptive Simpson integration over an 1D interval
    private static float AdaptiveSimpson(final Function<Float, Float> func, final float x0, final float x1,
            final float eps, final int depth) {
        final int count = 0;
        final float a = x0, b = 0.5f * (x0 + x1), c = x1;
        final float fa = func.apply(a), fb = func.apply(b), fc = func.apply(c);
        final float I = (c - a) * (float) (1.0 / 6.0) * (fa + 4 * fb + fc);
        return integrate(func, a, b, c, fa, fb, fc, I, eps, depth);
    }

    /// Nested adaptive Simpson integration over a 2D rectangle
    private static float AdaptiveSimpson2D(final BiFunction<Float, Float, Float> f, final float x0, final float y0,
            final float x1, final float y1, final float eps, final int depth) {
        /* Lambda function that integrates over the X axis */
        // Function<Float, Float> integrate = [apply:{float y ->
        // return AdaptiveSimpson(std::bind(f, std::placeholders::_1, y), x0, x1, eps,
        // depth)
        // }] as Function
        final float value = 0; // AdaptiveSimpson(integrate, y0, y1, eps, depth, 1e-6f, 6)
        return value;
    }

    // Numerically integrate the probability density function over rectangles in
    // spherical coordinates.
    private static void IntegrateFrequencyTable(final BSDF bsdf, final Vector3f wo, final int sampleCount, final int thetaRes, final int phiRes, final float[] target) {
        for (int i = 0; i < target.length; i++) target[i] = 0;

        final float factorTheta = Pbrt.Pi / thetaRes, factorPhi = (2 * Pbrt.Pi) / phiRes;

        BiFunction<Float, Float, Float> func = (Float theta, Float phi) -> {
            final float cosTheta = (float)Math.cos(theta), sinTheta = (float)Math.sin(theta);
            final float cosPhi = (float)Math.cos(phi), sinPhi = (float)Math.sin(phi);
            final Vector3f wiL = new Vector3f((float)sinTheta * cosPhi, (float)sinTheta * sinPhi, cosTheta);
            return bsdf.Pdf(wo, bsdf.LocalToWorld(wiL), BxDF.BSDF_ALL) * sinTheta;
        };

        int ndx = 0;
        for (int i = 0; i < thetaRes; ++i) {
            for (int j = 0; j < phiRes; ++j) {
                target[ndx++] = sampleCount * AdaptiveSimpson2D(func, (float)i * factorTheta, (float)j * factorPhi,
                        (float)(i + 1) * factorTheta, (float)(j + 1) * factorPhi, 1e-6f, 6);
            }
        }
    }

    private static class Cell {
        float expFrequency;
        int index;
    }

    private static class PairBS {
        boolean first;
        String second;

        PairBS(final boolean first, final String second) {
            this.first = first;
            this.second = second;
        }
    }

    /// Run A Chi^2 test based on the given frequency tables
    private static PairBS Chi2Test(final float[] frequencies, final float[] expFrequencies, final int thetaRes, final int phiRes,
        final int sampleCount, final float minExpFrequency, final float significanceLevel, final int numTests)
            throws Exception {

        /* Sort all cells by their expected frequencies */
        final ArrayList<Cell> cells = new ArrayList<>(thetaRes * phiRes);
        for (int i = 0; i < cells.size(); ++i) {
            cells.get(i).expFrequency = expFrequencies[i];
            cells.get(i).index = i;
        }
        Comparator<Cell> lessCell = (Cell a, Cell b) -> { return (a.expFrequency < b.expFrequency) ? -1 : 1; };
        cells.sort(lessCell);

        /* Compute the Chi^2 statistic and pool cells as necessary */
        float pooledFrequencies = 0, pooledExpFrequencies = 0, chsq = 0;
        int pooledCells = 0, dof = 0;

        for (Cell c : cells) {
            if (expFrequencies[c.index] == 0) {
                if (frequencies[c.index] > sampleCount * 1e-5f) {
                    /* Uh oh: samples in a c that should be completely empty
                       according to the probability density function. Ordinarily,
                       even a single sample requires immediate rejection of the null
                       hypothesis. But due to finite-precision computations and
                       rounding
                       errors, this can occasionally happen without there being an
                       actual bug. Therefore, the criterion here is a bit more
                       lenient. */

                    String result = String.format("Encountered %f samples in a c with expected frequency 0. Rejecting the null hypothesis!",
                            frequencies[c.index]);
                    return new PairBS(false, result);
                }
            } else if (expFrequencies[c.index] < minExpFrequency) {
                /* Pool cells with low expected frequencies */
                pooledFrequencies += frequencies[c.index];
                pooledExpFrequencies += expFrequencies[c.index];
                pooledCells++;
            } else if (pooledExpFrequencies > 0 &&
                    pooledExpFrequencies < minExpFrequency) {
                /* Keep on pooling cells until a sufficiently high
                   expected frequency is achieved. */
                pooledFrequencies += frequencies[c.index];
                pooledExpFrequencies += expFrequencies[c.index];
                pooledCells++;
            } else {
                float diff = frequencies[c.index] - expFrequencies[c.index];
                chsq += (diff * diff) / expFrequencies[c.index];
                ++dof;
            }
        }

        if (pooledExpFrequencies > 0 || pooledFrequencies > 0) {
            float diff = pooledFrequencies - pooledExpFrequencies;
            chsq += (diff * diff) / pooledExpFrequencies;
            ++dof;
        }

        /* All parameters are assumed to be known, so there is no
           additional DF reduction due to model parameters */
        dof -= 1;

        if (dof <= 0) {
            String result = String.format("The number of degrees of freedom %d is too low!", dof);
            return new PairBS(false, result);
        }

        /* Probability of obtaining a test statistic at least
           as extreme as the one observed under the assumption
           that the distributions match */
        float pval = 1 - (float)Chi2CDF(chsq, dof);

        /* Apply the Sidak correction term, since we'll be conducting multiple
           independent
           hypothesis tests. This accounts for the fact that the probability of a
           failure
           increases quickly when several hypothesis tests are run in sequence. */
        float alpha = 1.0f - (float)Math.pow(1.0f - significanceLevel, 1.0f / numTests);

        if (pval < alpha || !Float.isFinite(pval)) {
            String result = String.format("Rejected the null hypothesis (p-value = %f, significance level = %f", pval, alpha);
            return new PairBS(false, result);
        } else {
            return new PairBS(true, "");
        }
    }

    private static void TestBSDF(final Supplier<BSDF> createBSDF, final String description) throws Exception {

        Api.pbrtInit(new Options());

        final int thetaRes = CHI2_THETA_RES;
        final int phiRes = CHI2_PHI_RES;
        final int sampleCount = CHI2_SAMPLECOUNT;
        final float[] frequencies = new float[thetaRes * phiRes];
        final float[] expFrequencies = new float[thetaRes * phiRes];
        final RNG rng = new RNG(0);

        int index = 0;
        //std::cout.precision(3);

        // Create BSDF, which requires creating a Shape, casting a Ray that
        // hits the shape to get a SurfaceInteraction object.
        BSDF bsdf = null;
        final Transform t = Transform.RotateX(-90);
        final Transform tInv = Transform.Inverse(t);

        final boolean reverseOrientation = false;
        final ParamSet p = new ParamSet();

        final Shape disk = new Disk(t, tInv, reverseOrientation, 0.0f, 1.0f, 0, 360.0f);
        final Point3f origin = new Point3f(0.1f, 1, 0);  // offset slightly so we don't hit center of disk
        final Vector3f direction = new Vector3f(0, -1, 0);
        final Ray r = new Ray(origin, direction);
        final var intersect = disk.Intersect(r, false);
        final SurfaceInteraction isect = intersect.isect;
        final float tHit = intersect.tHit;

        bsdf = createBSDF.get();

        for (int k = 0; k < CHI2_RUNS; ++k) {
            /* Randomly pick an outgoing direction on the hemisphere */
            final Point2f sample = new Point2f(rng.UniformFloat(), rng.UniformFloat());
            final Vector3f woL = Sampling.CosineSampleHemisphere(sample);
            final Vector3f wo = bsdf.LocalToWorld(woL);

            FrequencyTable(bsdf, wo, rng, sampleCount, thetaRes, phiRes, frequencies);

            IntegrateFrequencyTable(bsdf, wo, sampleCount, thetaRes, phiRes, expFrequencies);

            //final String filename = String.format("/tmp/chi2test_%s_%03i.m", description, ++index);
            //DumpTables(frequencies, expFrequencies, thetaRes, phiRes, filename);

            final var result = Chi2Test(frequencies, expFrequencies, thetaRes, phiRes, sampleCount,
                    CHI2_MINFREQ, CHI2_SLEVEL, CHI2_RUNS);
            assertTrue(result.first); // << result.second << ", iteration " << k;
        }

        Api.pbrtCleanup();
    }

}
