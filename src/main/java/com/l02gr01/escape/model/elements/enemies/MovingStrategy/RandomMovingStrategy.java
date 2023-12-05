package com.l02gr01.escape.model.elements.enemies.MovingStrategy;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;

public class RandomMovingStrategy implements MovingStrategy {
    @Override
    public Position moveEnemy(Position position, Level level) {
        Position finalpos;
        do {
            finalpos = position.getRandomNeighbour();
        }while (!level.isEmpty(finalpos) && !level.getExit().getPosition().equals(finalpos));
        return finalpos;
    }
}
