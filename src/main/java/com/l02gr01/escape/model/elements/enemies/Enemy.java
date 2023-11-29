package com.l02gr01.escape.model.elements.enemies;

import com.l02gr01.escape.model.elements.Element;

public abstract class Enemy extends Element {

  private int life = 40;
  public Enemy(int x, int y) {
    super(x, y);
  }

  public abstract int getDamage();


  public boolean removeLife(int damage){
    // Returns true if died. Returns false if still alive.
    life = life - damage;
    System.out.println(life);
    if(life <= 0) {
      return true;
    }
    return false;
  }

  public abstract char getSymbol();

  public abstract String getColor();
}
