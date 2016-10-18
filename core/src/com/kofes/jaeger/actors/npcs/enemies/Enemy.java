package com.kofes.jaeger.actors.npcs.enemies;

import com.kofes.jaeger.actors.npcs.NPC;

/**
 */

public abstract class Enemy extends NPC {
    protected int damage;
    protected float timer;

    public final int damage () {
        return this.damage;
    }
    public final int damage (int damage) {
        return (this.damage = damage);
    }
}
