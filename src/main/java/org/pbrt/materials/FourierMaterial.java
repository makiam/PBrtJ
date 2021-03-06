
/*
 * PBrtJ -- Port of pbrt v3 to Java.
 * Copyright (c) 2017 Rick Weyrauch.
 *
 * pbrt source code is Copyright(c) 1998-2016
 * Matt Pharr, Greg Humphreys, and Wenzel Jakob.
 *
 */

package org.pbrt.materials;

import org.pbrt.core.*;

import java.util.HashMap;

public class FourierMaterial extends Material {

    public FourierMaterial(String filename, TextureFloat bumpMap) {
        this.bumpMap = bumpMap;
        if (!loadedBSDFs.containsKey(filename)) {
            FourierBSDFTable table = FourierBSDFTable.Read(filename);
            loadedBSDFs.put(filename, table);
            bsdfTable = table;
        }
        else {
            bsdfTable = loadedBSDFs.get(filename);
        }
    }

    public static Material Create(TextureParams mp) {
        TextureFloat bumpMap = mp.GetFloatTextureOrNull("bumpmap");
        return new FourierMaterial(mp.FindFilename("bsdffile", ""), bumpMap);
    }

    @Override
    public void ComputeScatteringFunctions(SurfaceInteraction si, TransportMode mode, boolean allowMultipleLobes) {
        // Perform bump mapping with _bumpMap_, if present
        if (bumpMap != null) Bump(bumpMap, si);
        si.bsdf = new BSDF(si, 1);
        // Checking for zero channels works as a proxy for checking whether the
        // table was successfully read from the file.
        if (bsdfTable.nChannels > 0)
            si.bsdf.Add(new FourierBSDF(bsdfTable, mode));
    }

    FourierBSDFTable bsdfTable;
    TextureFloat bumpMap;
    private static HashMap<String, FourierBSDFTable> loadedBSDFs = new HashMap<>();
}