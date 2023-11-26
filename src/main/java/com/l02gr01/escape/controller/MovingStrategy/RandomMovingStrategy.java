package com.l02gr01.escape.controller.MovingStrategy;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.enemies.Enemy;

public class RandomMovingStrategy extends MovingStrategy {
    @Override
    public void moveEnemy(Enemy enemy, Level level) {
        Position position;
        do {
            position = enemy.getPosition().getRandomNeighbour();
        }while (!level.isEmpty(position));
        enemy.setPosition(position);
    }
}
