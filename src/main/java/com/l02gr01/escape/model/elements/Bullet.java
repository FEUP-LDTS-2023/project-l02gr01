package com.l02gr01.escape.model.elements;

import com.l02gr01.escape.model.Position;

public class Bullet extends Element{

    private Position direction;

    private int damage;

    public Bullet(int x, int y, Position direction, int damage) {
        super(x, y);
        this.direction = direction;
        this.damage = damage;
    }

    public int getDamage(){
        return damage;
    }

    public Position getDirection() {
        return direction;
    }
}
