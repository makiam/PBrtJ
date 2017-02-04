/*
 * PBrtJ -- Port of pbrt v3 to Java.
 * Copyright (c) 2017 Rick Weyrauch.
 *
 * pbrt source code is Copyright(c) 1998-2016
 * Matt Pharr, Greg Humphreys, and Wenzel Jakob.
 *
 */

package org.pbrt.core;

import org.apache.commons.lang.NotImplementedException;
import java.util.ArrayList;

public class ParamSet {

    private class ParamSetItem<T> {
        public String Name;
        public T[] Values;
        public boolean LookedUp;

        public ParamSetItem(String name, T[] values) {
            Name = name;
            Values = values;
            LookedUp = false;
        }
    }

    public void AddFloat(String name, Float[] v) {
        EraseFloat(name);
        floats.add(new ParamSetItem<>(name, v));
    }

    public void AddInt(String name, Integer[] v) {
        EraseInt(name);
        ints.add(new ParamSetItem<>(name, v));
    }

    public void AddBoolean(String name, Boolean[] v) {
        EraseBoolean(name);
        bools.add(new ParamSetItem<>(name, v));
    }

    public void AddPoint2f(String name, Point2f[] v) {
        ErasePoint2f(name);
        point2fs.add(new ParamSetItem<>(name, v));
    }

    public void AddVector2f(String name, Vector2f[] v) {
        EraseVector2f(name);
        vector2fs.add(new ParamSetItem<>(name, v));
    }

    public void AddPoint3f(String name, Point3f[] v) {
        ErasePoint3f(name);
        point3fs.add(new ParamSetItem<>(name, v));
    }

    public void AddVector3f(String name, Vector3f[] v) {
        EraseVector3f(name);
        vector3fs.add(new ParamSetItem<>(name, v));
    }

    public void AddNormal3f(String name, Normal3f[] v) {
        EraseNormal3f(name);
        normals.add(new ParamSetItem<>(name, v));
    }

    public void AddString(String name, String[] v) {
        EraseString(name);
        strings.add(new ParamSetItem<>(name, v));
    }

    public void AddTexture(String name, String texname) {
        EraseTexture(name);
        String[] texnames = {texname};
        textures.add(new ParamSetItem<>(name, texnames));
    }

    public void AddRGBSpectrum(String name, Float[] v) {
        EraseSpectrum(name);
        assert v.length % 3 == 0;
        throw new NotImplementedException("TODO");
    }

    public void AddXYZSpectrum(String name, Float[] v) {
        EraseSpectrum(name);
        assert v.length % 3 == 0;
        throw new NotImplementedException("TODO");
    }

    public void AddBlackbodySpectrum(String name, Float[] v) {
        EraseSpectrum(name);
        assert v.length % 2 == 0;
        throw new NotImplementedException("TODO");
    }

    public void AddSampledSpectrumFiles(String name, String[] filenames) {
        EraseSpectrum(name);
        throw new NotImplementedException("TODO");
    }

    public void AddSampledSpectrum(String name, Float[] v) {
        EraseSpectrum(name);
        assert v.length % 2 == 0;
        throw new NotImplementedException("TODO");
    }

    public boolean EraseInt(String name) {
        for (int i = 0; i < ints.size(); ++i) {
            if (ints.get(i).Name == name) {
                ints.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean EraseBoolean(String name) {
        for (int i = 0; i < bools.size(); ++i) {
            if (bools.get(i).Name == name) {
                bools.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean EraseFloat(String name) {
        for (int i = 0; i < floats.size(); ++i) {
            if (floats.get(i).Name == name) {
                floats.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean ErasePoint2f(String name) {
        for (int i = 0; i < point2fs.size(); ++i) {
            if (point2fs.get(i).Name == name) {
                point2fs.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean EraseVector2f(String name) {
        for (int i = 0; i < vector2fs.size(); ++i) {
            if (vector2fs.get(i).Name == name) {
                vector2fs.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean ErasePoint3f(String name) {
        for (int i = 0; i < point3fs.size(); ++i) {
            if (point3fs.get(i).Name == name) {
                point3fs.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean EraseVector3f(String name) {
        for (int i = 0; i < vector3fs.size(); ++i) {
            if (vector3fs.get(i).Name == name) {
                vector3fs.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean EraseNormal3f(String name) {
        for (int i = 0; i < normals.size(); ++i) {
            if (normals.get(i).Name == name) {
                normals.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean EraseSpectrum(String name) {
        for (int i = 0; i < spectra.size(); ++i) {
            if (spectra.get(i).Name == name) {
                spectra.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean EraseString(String name) {
        for (int i = 0; i < strings.size(); ++i) {
            if (strings.get(i).Name == name) {
                strings.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean EraseTexture(String name) {
        for (int i = 0; i < textures.size(); ++i) {
            if (textures.get(i).Name == name) {
                textures.remove(i);
                return true;
            }
        }
        return false;
    }

    public float FindOneFloat(String name, float d) {
        for (ParamSetItem<Float> cur : floats) {
            if (cur.Name == name && cur.Values.length == 1) {
                cur.LookedUp = true;
                return cur.Values[0];
            }
        }
        return d;
    }

    public int FindOneInt(String name, int d) {
        for (ParamSetItem<Integer> cur : ints) {
            if (cur.Name == name && cur.Values.length == 1) {
                cur.LookedUp = true;
                return cur.Values[0];
            }
        }
        return d;
    }

    public boolean FindOneBoolean(String name, boolean d) {
        for (ParamSetItem<Boolean> cur : bools) {
            if (cur.Name == name && cur.Values.length == 1) {
                cur.LookedUp = true;
                return cur.Values[0];
            }
        }
        return d;
    }

    public Point2f FindOnePoint2f(String name, Point2f d) {
        for (ParamSetItem<Point2f> cur : point2fs) {
            if (cur.Name == name && cur.Values.length == 1) {
                cur.LookedUp = true;
                return cur.Values[0];
            }
        }
        return d;
    }

    public Vector2f FindOneVector2f(String name, Vector2f d) {
        for (ParamSetItem<Vector2f> cur : vector2fs) {
            if (cur.Name == name && cur.Values.length == 1) {
                cur.LookedUp = true;
                return cur.Values[0];
            }
        }
        return d;
    }

    public Point3f FindOnePoint3f(String name, Point3f d) {
        for (ParamSetItem<Point3f> cur : point3fs) {
            if (cur.Name == name && cur.Values.length == 1) {
                cur.LookedUp = true;
                return cur.Values[0];
            }
        }
        return d;
    }

    public Vector3f FindOneVector3f(String name, Vector3f d) {
        for (ParamSetItem<Vector3f> cur : vector3fs) {
            if (cur.Name == name && cur.Values.length == 1) {
                cur.LookedUp = true;
                return cur.Values[0];
            }
        }
        return d;
    }

    public Normal3f FindOneNormal3f(String name, Normal3f d) {
        for (ParamSetItem<Normal3f> cur : normals) {
            if (cur.Name == name && cur.Values.length == 1) {
                cur.LookedUp = true;
                return cur.Values[0];
            }
        }
        return d;
    }

    public Spectrum FindOneSpectrum(String name, Spectrum d) {
        for (ParamSetItem<Spectrum> cur : spectra) {
            if (cur.Name == name && cur.Values.length == 1) {
                cur.LookedUp = true;
                return cur.Values[0];
            }
        }
        return d;
    }

    public String FindOneString(String name, String d) {
        for (ParamSetItem<String> cur : strings) {
            if (cur.Name == name && cur.Values.length == 1) {
                cur.LookedUp = true;
                return cur.Values[0];
            }
        }
        return d;
    }

    public String FindOneFilename(String name, String d) {
        String filename = FindOneString(name, "");
        if (filename == "") return d;
        filename = FileUtil.AbsolutePath(FileUtil.ResolveFilename(filename));
        return filename;
    }

    public String FindTexture(String name) {
        for (ParamSetItem<String> cur : textures) {
            if (cur.Name == name && cur.Values.length == 1) {
                cur.LookedUp = true;
                return cur.Values[0];
            }
        }
        return "";
    }

    public Float[] FindFloat(String name) {
        for (ParamSetItem<Float> cur : floats) {
            if (cur.Name == name) {
                cur.LookedUp = true;
                return cur.Values;
            }
        }
        return null;
    }

    public Integer[] FindInt(String name) {
        for (ParamSetItem<Integer> cur : ints) {
            if (cur.Name == name) {
                cur.LookedUp = true;
                return cur.Values;
            }
        }
        return null;
    }

    public Boolean[] FindBoolean(String name) {
        for (ParamSetItem<Boolean> cur : bools) {
            if (cur.Name == name) {
                cur.LookedUp = true;
                return cur.Values;
            }
        }
        return null;
    }

    public Point2f[] FindPoint2f(String name) {
        for (ParamSetItem<Point2f> cur : point2fs) {
            if (cur.Name == name) {
                cur.LookedUp = true;
                return cur.Values;
            }
        }
        return null;
    }

    public Vector2f[] FindVector2f(String name) {
        for (ParamSetItem<Vector2f> cur : vector2fs) {
            if (cur.Name == name) {
                cur.LookedUp = true;
                return cur.Values;
            }
        }
        return null;
    }

    public Point3f[] FindPoint3f(String name) {
        for (ParamSetItem<Point3f> cur : point3fs) {
            if (cur.Name == name) {
                cur.LookedUp = true;
                return cur.Values;
            }
        }
        return null;
    }

    public Vector3f[] FindVector3f(String name) {
        for (ParamSetItem<Vector3f> cur : vector3fs) {
            if (cur.Name == name) {
                cur.LookedUp = true;
                return cur.Values;
            }
        }
        return null;
    }

    public Normal3f[] FindNormal3f(String name) {
        for (ParamSetItem<Normal3f> cur : normals) {
            if (cur.Name == name) {
                cur.LookedUp = true;
                return cur.Values;
            }
        }
        return null;
    }

    public Spectrum[] FindSpectrum(String name) {
        for (ParamSetItem<Spectrum> cur : spectra) {
            if (cur.Name == name) {
                cur.LookedUp = true;
                return cur.Values;
            }
        }
        return null;
    }

    public String[] FindString(String name) {
        for (ParamSetItem<String> cur : strings) {
            if (cur.Name == name) {
                cur.LookedUp = true;
                return cur.Values;
            }
        }
        return null;
    }

    public void ReportUnused() {
        for (ParamSetItem<Boolean> bool : bools) {
            if (!bool.LookedUp) {
                Error.Warning("Parameter \"%s\" not used.", bool.Name);
            }
        }
        for (ParamSetItem<Integer> anInt : ints) {
            if (!anInt.LookedUp) {
                Error.Warning("Parameter \"%s\" not used.", anInt.Name);
            }
        }
        for (ParamSetItem<Float> aFloat : floats) {
            if (!aFloat.LookedUp) {
                Error.Warning("Parameter \"%s\" not used.", aFloat.Name);
            }
        }
        for (ParamSetItem<Point2f> point2f : point2fs) {
            if (!point2f.LookedUp) {
                Error.Warning("Parameter \"%s\" not used.", point2f.Name);
            }
        }
        for (ParamSetItem<Vector2f> vector2f : vector2fs) {
            if (!vector2f.LookedUp) {
                Error.Warning("Parameter \"%s\" not used.", vector2f.Name);
            }
        }
        for (ParamSetItem<Point3f> point3f : point3fs) {
            if (!point3f.LookedUp) {
                Error.Warning("Parameter \"%s\" not used.", point3f.Name);
            }
        }
        for (ParamSetItem<Vector3f> vector3f : vector3fs) {
            if (!vector3f.LookedUp) {
                Error.Warning("Parameter \"%s\" not used.", vector3f.Name);
            }
        }
        for (ParamSetItem<Normal3f> normal : normals) {
            if (!normal.LookedUp) {
                Error.Warning("Parameter \"%s\" not used.", normal.Name);
            }
        }
        for (ParamSetItem<Spectrum> aSpectra : spectra) {
            if (!aSpectra.LookedUp) {
                Error.Warning("Parameter \"%s\" not used.", aSpectra.Name);
            }
        }
        for (ParamSetItem<String> string : strings) {
            if (!string.LookedUp) {
                Error.Warning("Parameter \"%s\" not used.", string.Name);
            }
        }
        for (ParamSetItem<String> texture : textures) {
            if (!texture.LookedUp) {
                Error.Warning("Parameter \"%s\" not used.", texture.Name);
            }
        }
    }

    public void Clear() {
        bools.clear();
        ints.clear();
        floats.clear();
        point2fs.clear();
        vector2fs.clear();
        point3fs.clear();
        vector3fs.clear();
        normals.clear();
        spectra.clear();
        strings.clear();
        textures.clear();
    }

    public String ToString() {
        throw new NotImplementedException("TODO");
    }

    public void Print(int indent) {
        throw new NotImplementedException("TODO");
    }

    private ArrayList<ParamSetItem<Boolean>> bools;
    private ArrayList<ParamSetItem<Integer>> ints;
    private ArrayList<ParamSetItem<Float>> floats;
    private ArrayList<ParamSetItem<Point2f>> point2fs;
    private ArrayList<ParamSetItem<Vector2f>> vector2fs;
    private ArrayList<ParamSetItem<Point3f>> point3fs;
    private ArrayList<ParamSetItem<Vector3f>> vector3fs;
    private ArrayList<ParamSetItem<Normal3f>> normals;
    private ArrayList<ParamSetItem<Spectrum>> spectra;
    private ArrayList<ParamSetItem<String>> strings;
    private ArrayList<ParamSetItem<String>> textures;
}