package com.l02gr01.escape.model.elements.enemies;

import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Element;

public class Troll extends Enemy {

  private final int damage = 10;
  public Troll(int x, int y) {
    super(x, y, 10, '&', "#116909");
  }

}
