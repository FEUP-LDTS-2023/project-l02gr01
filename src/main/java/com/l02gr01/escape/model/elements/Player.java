package com.l02gr01.escape.model.elements;

public class Player extends Element {
    private int health;

    public Player(int x, int y) {
        super(x, y);
        this.health = 100;
    }
}
