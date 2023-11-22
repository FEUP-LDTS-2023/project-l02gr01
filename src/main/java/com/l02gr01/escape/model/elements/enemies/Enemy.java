package com.l02gr01.escape.model.elements.enemies;

import com.l02gr01.escape.model.elements.Element;

public abstract class Enemy extends Element {

  public Enemy(int x, int y) {
    super(x, y);
  }

  public abstract int getDamage();

  public abstract char getSymbol();

  public abstract String getColor();
}
