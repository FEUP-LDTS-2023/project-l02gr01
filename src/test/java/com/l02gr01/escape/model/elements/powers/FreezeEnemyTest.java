package com.l02gr01.escape.model.elements.powers;

import com.googlecode.lanterna.Symbols;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreezeEnemyTest {

    FreezeEnemy freezeEnemy;

    @BeforeEach
    void setUp() {
        freezeEnemy = new FreezeEnemy(1, 2);
    }

    @Test
    void constructorTest() {
        assertEquals(1, freezeEnemy.getPosition().getX());
        assertEquals(2, freezeEnemy.getPosition().getY());
    }

    @Test
    void getTypeTest() {
        assertEquals(Power.PowerType.FREEZE_ENEMY, freezeEnemy.getType());
    }

    @Test
    void getSymbolTest() {
        assertEquals(Symbols.CLUB, freezeEnemy.getSymbol());
    }

    @Test
    void getColorTest() {
        assertEquals("#03fbff", freezeEnemy.getColor());
    }

    @Test
    void getPowerLengthTest() {
        assertEquals(10000L, freezeEnemy.getPowerLength());
    }
}