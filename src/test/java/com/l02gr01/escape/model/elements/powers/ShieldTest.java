package com.l02gr01.escape.model.elements.powers;


import com.googlecode.lanterna.Symbols;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShieldTest {

    Shield shield;

    @BeforeEach
    void setUp() {
        shield = new Shield(3, 4);
    }

    @Test
    void constructorTest() {
        assertEquals(3, shield.getPosition().getX());
        assertEquals(4, shield.getPosition().getY());
    }

    @Test
    void getTypeTest() {
        assertEquals(Power.PowerType.SHIELD, shield.getType());
    }

    @Test
    void getSymbolTest() {
        assertEquals(Symbols.INVERSE_WHITE_CIRCLE, shield.getSymbol());
    }

    @Test
    void getColorTest() {
        assertEquals("#a894ff", shield.getColor());
    }

    @Test
    void getPowerLengthTest() {
        assertEquals(10000L, shield.getPowerLength());
    }
}