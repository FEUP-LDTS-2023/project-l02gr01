package com.l02gr01.escape.model;

import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.elements.Wall;
import java.util.ArrayList;
import java.util.List;

public class Level {
  private int width;
  private int height;

  private Player player;
  private List<Wall> walls = new ArrayList<>();

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
}
