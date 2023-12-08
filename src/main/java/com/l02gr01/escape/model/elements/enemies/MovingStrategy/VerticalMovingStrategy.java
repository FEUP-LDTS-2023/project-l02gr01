package com.l02gr01.escape.model.elements.enemies.MovingStrategy;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;

public class VerticalMovingStrategy implements MovingStrategy{
    @Override
    public Position moveEnemy(Position position, Level level) {
        Position finalpos = position;
        do {
            int i = (int) (Math.random() * 2);
            switch (i){
                case 0: finalpos = position.getUp(); break;
                case 1: finalpos = position.getDown(); break;
            }
        }while (!level.isEmpty(finalpos) && !level.getExit().getPosition().equals(finalpos));
        return finalpos;
    }
}
