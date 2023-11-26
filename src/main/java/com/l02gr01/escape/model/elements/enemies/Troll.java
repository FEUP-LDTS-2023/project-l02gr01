package com.l02gr01.escape.model.elements.enemies;

import com.l02gr01.escape.model.elements.Element;

public class Troll extends Enemy {

  private final int damage = 10;
  public Troll(int x, int y) {
    super(x, y);
  }


  @Override
  public int getDamage() {
    return damage;
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
