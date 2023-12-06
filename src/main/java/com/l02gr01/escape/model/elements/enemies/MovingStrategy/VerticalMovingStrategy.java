package com.l02gr01.escape.model.elements.enemies.MovingStrategy;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;

public class VerticalMovingStrategy implements MovingStrategy{
    @Override
    public Position moveEnemy(Position position, Level level) {
        if(level.isEmpty(position.getUp()) && !level.getExit().getPosition().equals(position.getUp())) {
            return position.getUp();
        }
        if(level.isEmpty(position.getDown()) && !level.getExit().getPosition().equals(position.getDown())){
            return position.getDown();
        }
        return position;
    }
}
