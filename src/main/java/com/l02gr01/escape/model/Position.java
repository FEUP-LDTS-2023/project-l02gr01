package com.l02gr01.escape.model;

import java.util.Objects;

public class Position {
  private final int x;
  private final int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Position getLeft() {
    return new Position(x - 1, y);
  }

  public Position getRight() {
    return new Position(x + 1, y);
  }

  public Position getUp() {
    return new Position(x, y - 1);
  }

  public Position getDown() {
    return new Position(x, y + 1);
  }

  public Position getRandomNeighbour() {
    int n = (int) (Math.random() * 4);
    return switch (n) {
      case 0 -> getUp();
      case 1 -> getRight();
      case 2 -> getDown();
      default -> getLeft();
    };
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Position position)) return false;
      return x == position.x && y == position.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  public boolean iswithindistance(Position center, int n){
    return Math.abs(getX() - center.getX()) <= n && Math.abs(getY() - center.getY()) <= n;
  }
}
