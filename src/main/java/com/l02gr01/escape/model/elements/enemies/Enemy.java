package com.l02gr01.escape.model.elements.enemies;

import com.l02gr01.escape.model.elements.Element;
import com.l02gr01.escape.model.elements.enemies.MovingStrategy.MovingStrategy;
import com.l02gr01.escape.model.elements.enemies.MovingStrategy.RandomMovingStrategy;

public class Enemy extends Element {


  private int life = 40;

  final int damage;
  final String color;

  final MovingStrategy strategy = new RandomMovingStrategy();  // Just for example

  public Enemy(int x, int y){
    // Supposed to be a troll
    super(x, y);
    this.damage = 10;
    this.color = "#116909";
  }
  public Enemy(int x, int y, int damage, String color) {
    super(x, y);
    this.damage = damage;
    this.color = color;
  }

  public MovingStrategy getStrategy(){
    return strategy;
  }

  public int getDamage(){
    return damage;
  }




  public boolean removeLife(int damage){
    // Returns true if died. Returns false if still alive.
    life = life - damage;
    System.out.println(life);
    return life <= 0;
  }

  public String getColor(){
    return color;
  }

}
