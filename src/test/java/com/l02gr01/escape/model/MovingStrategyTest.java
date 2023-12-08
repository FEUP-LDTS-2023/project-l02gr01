package com.l02gr01.escape.model;

import com.l02gr01.escape.model.elements.enemies.MovingStrategy.HorizontalMovingStrategy;
import com.l02gr01.escape.model.elements.enemies.MovingStrategy.MovingStrategy;
import com.l02gr01.escape.model.elements.enemies.MovingStrategy.RandomMovingStrategy;
import com.l02gr01.escape.model.elements.enemies.MovingStrategy.VerticalMovingStrategy;
import net.jqwik.api.ForAll;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.BeforeEach;
import net.jqwik.api.*;

import static java.lang.Math.abs;

public class MovingStrategyTest {

    MovingStrategy randomstrategy = new RandomMovingStrategy();
    MovingStrategy horizontalstrategy = new HorizontalMovingStrategy();
    Level emptylevel = new Level(50,50, 0);
    MovingStrategy verticalstrategy = new VerticalMovingStrategy();

    // Guarantees that only moves one position!
    @Property
    void RandomStrategy(@ForAll @IntRange(min = 0, max=49) int a, @ForAll @IntRange(min = 0, max = 49) int b) {
        Position p = new Position(a,b);
        Position newp = randomstrategy.moveEnemy(p, emptylevel);
        assert(abs(p.getY() - newp.getY() + p.getX() -newp.getX())  == 1);
    }

    // Guarantees that movement is just horizontal
    @Property
    void HorizontalStrategy(@ForAll @IntRange(min = 0, max=49) int a, @ForAll @IntRange(min = 0, max = 49) int b){
        Position p = new Position(a,b);
        Position newp = horizontalstrategy.moveEnemy(p, emptylevel);
        assert(abs(p.getX() - newp.getX()) == 1);
        assert(abs(p.getY() - newp.getY()) == 0);
    }

    // Guarantees that movement is just vertical
    @Property
    void VerticalStrategy(@ForAll @IntRange(min = 0, max=49) int a, @ForAll @IntRange(min = 0, max = 49) int b){
        Position p = new Position(a,b);
        Position newp = verticalstrategy.moveEnemy(p, emptylevel);
        assert(abs(p.getX() - newp.getX()) == 0);
        assert(abs(p.getY() - newp.getY()) == 1);
    }
}
