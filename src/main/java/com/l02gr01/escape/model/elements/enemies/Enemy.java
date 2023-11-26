package com.l02gr01.escape.model.elements.enemies;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Element;
import com.l02gr01.escape.model.elements.enemies.MovingStrategy.MovingStrategy;
import com.l02gr01.escape.model.elements.enemies.MovingStrategy.RandomMovingStrategy;

public abstract class Enemy extends Element {

  int damage;
  char symbol;
  String color;

  MovingStrategy strategy = new RandomMovingStrategy();  // Just for example

  public Enemy(int x, int y, int damage, char symbol, String color) {
    super(x, y);
    this.damage = damage;
    this.symbol = symbol;
    this.color = color;
  }

  public MovingStrategy getStrategy(){
    return strategy;
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

}
