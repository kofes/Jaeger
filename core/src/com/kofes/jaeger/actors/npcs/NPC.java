package com.kofes.jaeger.actors.npcs;

import com.badlogic.gdx.math.Vector2;

/**
 */

public abstract class NPC {
    public static enum TYPE {
        TREE, BUG, WOODSEEKER, BIRD
    }

    protected Vector2 position;
    protected TYPE type;
    protected int hp;

    public final TYPE type () {
        return type;
    }
    public final int HitPoints () {
        return (hp > 0) ? hp : 0;
    }
    public final void hit (int damage) {
        hp -= damage;
    }
    public final Vector2 position () {
        return this.position;
    }
    public final Vector2 position (Vector2 position) {
        return (this.position = position);
    }

}
