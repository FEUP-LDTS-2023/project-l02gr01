package com.l02gr01.escape.model.elements;

import com.l02gr01.escape.model.Position;

public class Bullet extends Element{

    private Position direction;
    public Bullet(int x, int y, Position direction) {
        super(x, y);
        this.direction = direction;
    }



}
