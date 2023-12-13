package com.l02gr01.escape.model.elements.enemies.MovingStrategy;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Exit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class HorizontalMovingStrategyTest {

    @Test
    void moveEnemyTest() {
        Level level = Mockito.mock(Level.class);
        Exit exit = Mockito.mock(Exit.class);
        Mockito.when(level.getExit()).thenReturn(exit);
        Mockito.when(exit.getPosition()).thenReturn(new Position(10, 10));
        HorizontalMovingStrategy movingStrategy = new HorizontalMovingStrategy();
        Position initialPosition = new Position(3, 4);

        Mockito.when(level.isEmpty(new Position(4, 4))).thenReturn(true);
        Mockito.when(level.isEmpty(new Position(2, 4))).thenReturn(false);
        Position newPositionRight = movingStrategy.moveEnemy(initialPosition, level);

        assertTrue(newPositionRight.equals(new Position(4, 4)));
        assertFalse(newPositionRight.equals(initialPosition));


        Mockito.when(level.isEmpty(new Position(4, 4))).thenReturn(false);
        Mockito.when(level.isEmpty(new Position(2, 4))).thenReturn(true);
        Position newPositionLeft = movingStrategy.moveEnemy(initialPosition, level);

        assertTrue(newPositionLeft.equals(new Position(2, 4)));
        assertFalse(newPositionLeft.equals(initialPosition));

    }
}