package com.l02gr01.escape.model.elements.powers;

import com.googlecode.lanterna.Symbols;

public class FreezeEnemy extends Power {

  public FreezeEnemy(int x, int y) {
    super(x, y);
  }

  @Override
  public PowerType getType() {
    return PowerType.FREEZE_ENEMY;
  }

  @Override
  public char getSymbol() {
    return Symbols.CLUB;
  }

  @Override
  public String getColor() {
    return "#03fbff";
  }

  @Override
  public Long getPowerLength() {
    return 10000L;
  }
}
