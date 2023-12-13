package com.l02gr01.escape.model.elements.powers;


import com.googlecode.lanterna.Symbols;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SuperVisionTest {

    SuperVision superVision;

    @BeforeEach
    void setUp() {
        superVision = new SuperVision(5, 6);
    }

    @Test
    void constructorTest() {
        assertEquals(5, superVision.getPosition().getX());
        assertEquals(6, superVision.getPosition().getY());
    }

    @Test
    void getTypeTest() {
        assertEquals(Power.PowerType.SUPER_VISION, superVision.getType());
    }

    @Test
    void getSymbolTest() {
        assertEquals(Symbols.CLUB, superVision.getSymbol());
    }

    @Test
    void getColorTest() {
        assertEquals("#ff00ff", superVision.getColor());
    }

    @Test
    void getPowerLengthTest() {
        assertEquals(5000L, superVision.getPowerLength());
    }
}