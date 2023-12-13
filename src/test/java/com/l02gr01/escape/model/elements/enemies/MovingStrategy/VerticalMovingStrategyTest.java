package com.l02gr01.escape.model.elements.enemies.MovingStrategy;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Exit;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class VerticalMovingStrategyTest {

    @Test
    void moveEnemyTest() {

        Level level = Mockito.mock(Level.class);
        Exit exit = Mockito.mock(Exit.class);
        Mockito.when(level.getExit()).thenReturn(exit);
        Mockito.when(exit.getPosition()).thenReturn(new Position(10, 10));
        VerticalMovingStrategy movingStrategy = new VerticalMovingStrategy();
        Position initialPosition = new Position(3, 4);

        Mockito.when(level.isEmpty(new Position(3, 3))).thenReturn(true);
        Mockito.when(level.isEmpty(new Position(3, 5))).thenReturn(false);
        Position newPositionRight = movingStrategy.moveEnemy(initialPosition, level);

        assertTrue(newPositionRight.equals(new Position(3, 3)));
        assertFalse(newPositionRight.equals(initialPosition));

        Mockito.when(level.isEmpty(new Position(3, 3))).thenReturn(false);
        Mockito.when(level.isEmpty(new Position(3, 5))).thenReturn(true);
        Position newPositionLeft = movingStrategy.moveEnemy(initialPosition, level);

        assertEquals(newPositionLeft, new Position(3, 5));
        assertFalse(newPositionLeft.equals(initialPosition));
    }
}