package com.kofes.jaeger.geometry;

import com.badlogic.gdx.math.Vector3;
import com.kofes.jaeger.settings.RGBA;

/**
 */

public final class Triangle {
    private Vector3 x, y;

    private RGBA rgba;

    public Triangle (
            float x1, float y1,
            float x2, float y2,
            float x3, float y3) {
        rgba = new RGBA();
        x = new Vector3(x1, x2, x3);
        y = new Vector3(y1, y2, y3);
    }

    public Triangle (Triangle trgl) {
        this(trgl.x1(), trgl.y1(), trgl.x2(), trgl.y2(), trgl.x3(), trgl.y3());
        this.rgba = new RGBA(trgl.rgba);
    }

    public void scale (float width, float height) {
        x.scl(width);
        y.scl(height);
    }

    public void add (float addX, float addY) {
        x.add(addX);
        y.add(addY);
    }

    public void setCoords (
            float x1, float y1,
            float x2, float y2,
            float x3, float y3) {
        x.set(x1, x2, x3);
        y.set(y1, y2, y3);
    }

    public void setColor (int r, int g, int b) {
        rgba.set(r, g, b, 255);
    }
    public void setColor (int r, int g, int b, int a) {
        rgba.set(r, g, b, a);
    }

    public float x1 () {return x.x;}
    public float x2 () {return x.y;}
    public float x3 () {return x.z;}
    public float y1 () {return y.x;}
    public float y2 () {return y.y;}
    public float y3 () {return y.z;}

    public float red ()   {return rgba.red();}
    public float green () {return rgba.green();}
    public float blue ()  {return rgba.blue();}
    public float alpha ()  {return rgba.alpha();}
}
