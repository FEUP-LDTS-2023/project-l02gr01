package com.l02gr01.escape.model.elements.enemies.MovingStrategy;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Exit;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RandomMovingStrategyTest {

    @Test
    void moveEnemyTest() {
        Level level = Mockito.mock(Level.class);
        RandomMovingStrategy movingStrategy = new RandomMovingStrategy();
        Position initialPosition = new Position(3, 4);

        Mockito.when(level.isEmpty(new Position(4, 4))).thenReturn(true);
        Mockito.when(level.isEmpty(new Position(2, 4))).thenReturn(true);
        Mockito.when(level.isEmpty(new Position(3, 3))).thenReturn(true);
        Mockito.when(level.isEmpty(new Position(3, 5))).thenReturn(true);

        Exit exit = Mockito.mock(Exit.class);
        Mockito.when(level.getExit()).thenReturn(exit);
        Mockito.when(exit.getPosition()).thenReturn(new Position(10, 10));

        Position newPosition = movingStrategy.moveEnemy(initialPosition, level);
        assertTrue(newPosition.equals(new Position(4, 4)) ||
                newPosition.equals(new Position(2, 4)) ||
                newPosition.equals(new Position(3, 3)) ||
                newPosition.equals(new Position(3, 5)));
        assertFalse(newPosition.equals(initialPosition));

        Mockito.when(level.isEmpty(new Position(4, 4))).thenReturn(false);
        Mockito.when(level.isEmpty(new Position(2, 4))).thenReturn(true);
        Mockito.when(level.isEmpty(new Position(3, 3))).thenReturn(false);
        Mockito.when(level.isEmpty(new Position(3, 5))).thenReturn(true);

        newPosition = movingStrategy.moveEnemy(initialPosition, level);
        assertTrue(newPosition.equals(new Position(2, 4)) ||
                newPosition.equals(new Position(3, 5)));
        assertFalse(newPosition.equals(initialPosition));
    }
}