package com.l02gr01.escape.model.elements.enemies.MovingStrategy;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;

public interface MovingStrategy {
     Position moveEnemy(Position position, Level level);
}
