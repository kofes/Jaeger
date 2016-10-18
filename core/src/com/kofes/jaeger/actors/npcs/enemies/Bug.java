package com.kofes.jaeger.actors.npcs.enemies;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.kofes.jaeger.actors.npcs.NPC;

/**
 */

public class Bug extends Enemy {
    private Circle circle;

    public Bug (Vector2 position, int hitPoints, int damage) {
        this.type = NPC.TYPE.BUG;
        this.position = position;
        this.hp = hitPoints;
        this.damage = damage;
        this.circle = new Circle();
    }
    public Bug (Vector2 position) {
        this.type = NPC.TYPE.BUG;
        this.position = position;
        this.hp = 3;
        this.damage = 1;
        this.circle = new Circle();
    }
    public Bug (Vector2 position, int hitPoints) {
        this.type = NPC.TYPE.BUG;
        this.position = position;
        this.hp = hitPoints;
        this.damage = 1;
        this.circle = new Circle();
    }

}
