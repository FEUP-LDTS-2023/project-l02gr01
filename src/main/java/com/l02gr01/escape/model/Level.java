package com.l02gr01.escape.model;

import com.l02gr01.escape.model.elements.*;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import com.l02gr01.escape.model.elements.powers.Power;
import java.util.ArrayList;
import java.util.List;

public class Level {

  private int width;
  private int height;
  private final int levelNumber;

  private Player player;
  private List<Wall> walls = new ArrayList<Wall>();
  private Keys keys = new Keys();
  private Exit exit = new Exit(5,0);

  private List<Power> powers = new ArrayList<Power>();

  private List<Enemy> enemies = new ArrayList<Enemy>();

  public Level(int width, int height, int levelNumber) {
    this.width = width;
    this.height = height;
    this.levelNumber = levelNumber;
  }


  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public List<Wall> getWalls() {
    return walls;
  }

  public void setWalls(List<Wall> walls) {
    this.walls = walls;
  }

  public Keys getKeys() {
    return keys;
  }

  public void setKeys(Keys keys) {
    this.keys = keys;
  }

  public Exit getExit() {
    return exit;
  }

  public void setExit(Exit exit) {
    this.exit = exit;
  }

  public boolean isEmpty(Position position) {
    for (Wall wall : walls) {
      if (wall.getPosition().equals(position)) {
        return false;
      }
    }
    return exit.isOpen() || !exit.getPosition().equals(position);
  }

  public List<Enemy> getEnemies() {
    return enemies;
  }

  public void setEnemies(List<Enemy> enemies) {
    this.enemies = enemies;
  }

  public Enemy getEnemy(Position position) {
    for (Enemy enemy : enemies) {
      if (enemy.getPosition().equals(position)) {
        return enemy;
      }
    }
    return null;
  }

  public List<Power> getPowers() {
    return powers;
  }

  public void setPowers(List<Power> powers) {
    this.powers = powers;
  }

  public Power getPower(Position position) {
    for (Power power : powers) {
      if (power.getPosition().equals(position)) {
        return power;
      }
    }
    return null;
  }

  public void removePower(Power power) {
    powers.remove(power);
  }

  public int getLevelNumber() {
    return levelNumber;
  }
}
