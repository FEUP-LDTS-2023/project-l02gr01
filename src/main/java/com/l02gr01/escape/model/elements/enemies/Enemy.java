package com.l02gr01.escape.model.elements.enemies;

import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Element;

public abstract class Enemy extends Element {

  int damage;
  char symbol;
  String color;

  public Enemy(int x, int y, int damage, char symbol, String color) {
    super(x, y);
    this.damage = damage;
    this.symbol = symbol;
    this.color = color;
  }

  public int getDamage(){
    return damage;
  };

  public  char getSymbol(){
    return symbol;
  };

  public String getColor(){
    return color;
  };
  public abstract Position nextMove();
}
