package com.kofes.jaeger.actors;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.kofes.jaeger.game.Jaeger;
import com.kofes.jaeger.geometry.Rectangle;
import com.kofes.jaeger.settings.RGBA;

/**
 */

public class Surface {
    private Rectangle surface;

    public static final RGBA RGB_SURFACE = new RGBA(183, 255, 89);

    private static Surface ourInstance = new Surface();

    public static Surface getInstance() {
        return ourInstance;
    }

    private Surface() {
        surface = new Rectangle(
                0.50f, 0.12f,
                0.50f, 0.12f
        );
    }

    public Rectangle surface () {
        Rectangle res = new Rectangle(surface);
        res.scale(Jaeger.WIDTH, Jaeger.HEIGHT);
        res.setColor(183, 255, 89);
        return res;
    }

    public void draw (ShapeRenderer shapeRenderer) {
        Rectangle surface = surface();
        shapeRenderer.setColor(RGB_SURFACE.red(), RGB_SURFACE.green(), RGB_SURFACE.blue(), RGB_SURFACE.alpha());
        shapeRenderer.rect(
                surface.x(), surface.y(),
                surface.w(), surface.h()
        );
    }

}

