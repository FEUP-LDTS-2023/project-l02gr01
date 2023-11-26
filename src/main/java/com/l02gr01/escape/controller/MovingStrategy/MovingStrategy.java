package com.l02gr01.escape.controller.MovingStrategy;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.enemies.Enemy;

public abstract class MovingStrategy {
    public abstract void moveEnemy(Enemy enemy, Level level);
}
