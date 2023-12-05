package com.l02gr01.escape.model.elements.powers;

import com.googlecode.lanterna.Symbols;

public class SuperVision extends Power {

    public SuperVision(int x, int y) {
        super(x, y);
    }

    @Override
    public PowerType getType() {
        return PowerType.SUPER_VISION;
    }

    @Override
    public char getSymbol() {
        return Symbols.CLUB;
    }

    @Override
    public String getColor() {
        return "#ff00ff";
    }

    @Override
    public Long getPowerLength() {
        return 5000L;
    }
}
