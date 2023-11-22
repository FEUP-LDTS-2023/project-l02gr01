package com.l02gr01.escape.model;

import com.l02gr01.escape.model.elements.Exit;
import com.l02gr01.escape.model.elements.Key;
import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.elements.Wall;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import java.util.ArrayList;
import java.util.List;

public class Level {
  private int width;
  private int height;

  private Player player;
  private List<Wall> walls = new ArrayList<>();
  private List<Key> keys = new ArrayList<>();
  private Exit exit = new Exit(5,0);

  private List<Enemy> enemies = new ArrayList();

  public Level(int width, int height) {
    this.width = width;
    this.height = height;
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

  public List<Key> getKeys() {
    return keys;
  }

  public void setKeys(List<Key> keys) {
    this.keys = keys;
  }

  public Exit getExit() {
    return exit;
  }

  public void setExit(Exit exit) {
    this.exit = exit;
  }

  public boolean isEmpty(Position position) {
    for (Wall wall : walls)
      if (wall.getPosition().equals(position))
        return false;
    return exit.isOpen() || !exit.getPosition().equals(position);
  }

  public Key getKey(Position position) {
    for (Key key : keys)
      if (key.getPosition().equals(position))
        return key;
    return null;
  }

  public int getRemainingKeys() {
    int remainingKeys = keys.size();
    for (Key key : keys) {
      if (key.isPickedUp()) {
        remainingKeys--;
      }
    }
    return remainingKeys;
  }

  public List<Enemy> getEnemies() {
    return enemies;
  }

  public void setEnemies(List<Enemy> enemies) {
    this.enemies = enemies;
  }

  public Enemy getEnemy(Position position) {
    for (Enemy enemy : enemies)
      if (enemy.getPosition().equals(position))
        return enemy;
    return null;
  }
}
