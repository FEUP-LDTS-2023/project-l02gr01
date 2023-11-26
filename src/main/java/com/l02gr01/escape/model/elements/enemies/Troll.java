package com.l02gr01.escape.model.elements.enemies;

import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Element;

public class Troll extends Enemy {

  public Troll(int x, int y) {
    super(x, y, 10, '&', "#116909");
  }


  @Override
  public Position nextMove() {
    // For example, move right until a wall, then left and vice versa
    return null;
  }
}
