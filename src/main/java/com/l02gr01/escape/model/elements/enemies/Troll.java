package com.l02gr01.escape.model.elements.enemies;

import com.l02gr01.escape.model.elements.Element;

public class Troll extends Enemy {

  public Troll(int x, int y) {
    super(x, y);
  }


  @Override
  public int getDamage() {
    return 10;
  }

  @Override
  public char getSymbol() {
    return '&';
  }

  @Override
  public String getColor() {
    return "#116909";
  }
}
