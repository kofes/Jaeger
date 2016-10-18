package com.kofes.jaeger.actors.npcs;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.kofes.jaeger.game.Jaeger;
import com.kofes.jaeger.geometry.Ellipse;
import com.kofes.jaeger.geometry.Rectangle;
import com.kofes.jaeger.geometry.Triangle;
import com.kofes.jaeger.settings.RGBA;

/**
 */

public class Tree extends NPC {

    public static final RGBA RGBA_CROWN = new RGBA(79, 209, 75);
    public static final RGBA RGBA_STEM = new RGBA(178, 125, 67);
    public static final RGBA RGBA_SHADOW = new RGBA(0, 0, 0, 51);

    private Triangle[] crown;
    private Rectangle stem;
    private Ellipse shadow;

    public Tree (Vector2 position, int hitPoints) {
        this.type = TYPE.TREE;
        this.position = position;
        this.hp = hitPoints;
        initShapes();
    }

    public Tree (Vector2 position) {
        this.type = TYPE.TREE;
        this.position = position;
        this.hp = 100;
        initShapes();
    }

    public Triangle topTriangle () {
        Triangle res = new Triangle(crown[0]);
        res.add(position.x, position.y);
        res.scale(Jaeger.WIDTH, Jaeger.HEIGHT);
        res.setColor(79, 209, 75);
        return res;
    }
    public Triangle middleTriangle () {
        Triangle res = new Triangle(crown[1]);
        res.add(position.x, position.y);
        res.scale(Jaeger.WIDTH, Jaeger.HEIGHT);
        res.setColor(79, 209, 75);
        return res;
    }
    public Triangle bottomTriangle () {
        Triangle res = new Triangle(crown[2]);
        res.add(position.x, position.y);
        res.scale(Jaeger.WIDTH, Jaeger.HEIGHT);
        res.setColor(79, 209, 75);
        return res;
    }
    public Rectangle stem () {
        Rectangle res = new Rectangle(stem);
        res.addCoords(position.x, position.y);
        res.scale(Jaeger.WIDTH, Jaeger.HEIGHT);
        res.setColor(178, 125, 67);
        return res;
    }
    public Ellipse shadow () {
        Ellipse res = new Ellipse(shadow);
        res.addCoords(position.x, position.y);
        res.scale(Jaeger.WIDTH, Jaeger.HEIGHT);
        res.setColor(0, 0, 0);
        return res;
    }

    public void draw (ShapeRenderer shapeRenderer) {
        //SHADOW!
        Ellipse shadow = shadow();
        shapeRenderer.setColor(RGBA_SHADOW.red(), RGBA_SHADOW.green(), RGBA_SHADOW.blue(), RGBA_SHADOW.alpha());
        shapeRenderer.ellipse(
                shadow.x(), shadow.y(),
                shadow.w(), shadow.h()
        );
        //STEM
        Rectangle stem = stem();
        shapeRenderer.setColor(RGBA_STEM.red(), RGBA_STEM.green(), RGBA_STEM.blue(), RGBA_STEM.alpha());
        shapeRenderer.rect(
                stem.x(), stem.y(),
                stem.w(), stem.h()
        );
        //CROWN!
        Triangle[] crown = new Triangle[3];
        crown[0] = topTriangle();
        crown[1] = bottomTriangle();
        crown[2] = middleTriangle();
        shapeRenderer.setColor(RGBA_CROWN.red(), RGBA_CROWN.green(), RGBA_CROWN.blue(), RGBA_STEM.alpha());
        for (int i = 0; i < 3; ++i)
            shapeRenderer.triangle(
                    crown[i].x1(), crown[i].y1(),
                    crown[i].x2(), crown[i].y2(),
                    crown[i].x3(), crown[i].y3()
            );
    }

    private void initShapes () {
        crown = new Triangle[3];
        crown[0] = new Triangle(
                -0.08f, 0.00f,
                0.00f, 0.20f,
                0.08f, 0.00f
        );
        crown[1] = new Triangle(
                -0.12f, 0.00f,
                0.00f, 0.30f,
                0.12f, 0.00f
        );
        crown[2] = new Triangle(
                -0.16f, 0.00f,
                0.00f, 0.35f,
                0.16f, 0.00f
        );
        stem = new Rectangle(
                0.00f, 0.00f,
                0.04f, 0.05f
        );
        shadow = new Ellipse(
                0.00f, 0.00f,
                0.08f, 0.04f
        );
        //Фиксируем верхние вершины треугольников в центре сверху стоящего.
        crown[1].add(0, -(crown[1].y2() - crown[0].y2() + (crown[0].y2() - crown[0].y1()) / 2));
        crown[2].add(0, -(crown[2].y2() - crown[1].y2() + (crown[1].y2() - crown[1].y1()) / 2));
        //Смещаем позицию дерева на середину нижней части кроны.
        float dist = crown[0].y1() - crown[2].y1();
        for (int i = 0; i < 3; ++i)
            crown[i].add(0, dist);

        stem.setCoords(crown[2].x2(), crown[2].y1() - stem.w() / 2);

        shadow.addCoords(0, stem.y());
    }
}
