package com.l02gr01.escape.model.elements.powers;

public class Shield extends Power {

  public Shield(int x, int y) {
    super(x, y);
  }

  @Override
  public PowerType getType() {
    return PowerType.SHIELD;
  }

  @Override
  public char getSymbol() {
    return 'O';
  }

  @Override
  public String getColor() {
    return "#03fbff";
  }
}
