package com.l02gr01.escape.model.elements.powers;

import com.googlecode.lanterna.Symbols;

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
    return Symbols.INVERSE_WHITE_CIRCLE;
  }

  @Override
  public String getColor() {
    return "#a894ff";
  }

  @Override
  public Long getPowerLength() {
    return 10000L;
  }
}
