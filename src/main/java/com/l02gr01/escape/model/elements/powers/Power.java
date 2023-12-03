package com.l02gr01.escape.model.elements.powers;

import com.l02gr01.escape.model.elements.Element;

public abstract class Power extends Element {

  public Power(int x, int y) {
    super(x, y);
  }

  public enum PowerType {SHIELD, FREEZE_ENEMY}

  public abstract PowerType getType();

  public abstract char getSymbol();

  public abstract String getColor();
}
