package com.l02gr01.escape.model.elements.enemies.MovingStrategy;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;

public class HorizontalMovingStrategy implements MovingStrategy {

    @Override
    public Position moveEnemy(Position position, Level level) {
        if(level.isEmpty(position.getLeft()) && !level.getExit().getPosition().equals(position.getLeft())) {
            return position.getLeft();
        }
        if(level.isEmpty(position.getRight()) && !level.getExit().getPosition().equals(position.getRight())){
            return position.getRight();
        }
        return position;
    }
}
