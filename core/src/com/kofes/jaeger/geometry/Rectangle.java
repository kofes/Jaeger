package com.kofes.jaeger.geometry;

import com.kofes.jaeger.settings.RGBA;

/**
 */

public final class Rectangle {
    private float xCenter, yCenter;
    private float width, height;

    private RGBA rgba;

    public Rectangle (
            float xCenter, float yCenter,
            float wRad, float hRad
    ) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.width = wRad;
        this.height = hRad;
        this.rgba = new RGBA();
    }

    public Rectangle (Rectangle rect) {
        this(rect.xCenter, rect.yCenter, rect.width, rect.height);
        this.rgba = new RGBA(rect.rgba);
    }

    public void set (
            float xCenter, float yCenter,
            float wRad, float hRad) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.width = wRad;
        this.height = hRad;
    }

    public void setCoords (float xCenter, float yCenter) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public void scaleSize (float width, float height) {
        this.width *= width;
        this.height *= height;
    }

    public void scaleCoords (float width, float height) {
        this.xCenter *= width;
        this.yCenter *= height;
    }

    public void scale (float width, float height) {
        scaleSize(width, height);
        scaleCoords(width, height);
    }

    public void addCoords (float addX, float addY) {
        this.xCenter += addX;
        this.yCenter += addY;
    }

    public void setColor (int r, int g, int b) {
        rgba.set(r, g, b, 255);
    }
    public void setColor (int r, int g, int b, int a) {
        rgba.set(r, g, b, a);
    }

    public float x () {return xCenter - width;}
    public float y () {return yCenter - height;}
    public float w () {return 2*width;}
    public float h () {return 2*height;}

    public float red ()   {return rgba.red();}
    public float green () {return rgba.green();}
    public float blue ()  {return rgba.blue();}
    public float alpha ()  {return rgba.alpha();}
}
