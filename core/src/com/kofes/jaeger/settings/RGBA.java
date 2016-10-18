package com.kofes.jaeger.settings;

/**
 */

public final class RGBA {
    public char red, green, blue, alpha;

    public RGBA () {
        red = green = blue = alpha = 0;
    }
    public RGBA (char red, char green, char blue, char alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }
    public RGBA (int red, int green, int blue, int alpha) {
        this.red = (char)red;
        this.green = (char)green;
        this.blue = (char)blue;
        this.alpha = (char)alpha;
    }
    public RGBA (RGBA rgba) {
        this.set(rgba.red, rgba.green, rgba.blue, rgba.alpha);
    }
    public RGBA (char red, char green, char blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = 255;
    }
    public RGBA (int red, int green, int blue) {
        this.red = (char)red;
        this.green = (char)green;
        this.blue = (char)blue;
        this.alpha = 255;
    }
    public void set (char red, char green, char blue, char alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }
    public void set (int red, int green, int blue, int alpha) {
        this.red = (char)red;
        this.green = (char)green;
        this.blue = (char)blue;
        this.alpha = (char)alpha;
    }
    public final float red () {
        return red / 255f;
    }
    public final float green () {
        return green / 255f;
    }
    public final float blue () {
        return blue / 255f;
    }
    public final float alpha () {
        return alpha / 255f;
    }
}
