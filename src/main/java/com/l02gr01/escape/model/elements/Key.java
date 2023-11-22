package com.l02gr01.escape.model.elements;

public class Key extends Element {
  private boolean isPickedUp = false;
  public Key(int x, int y) {
    super(x, y);
  }

  public boolean isPickedUp() {
    return isPickedUp;
  }

  public void setPickedUp(boolean pickedUp) {
    isPickedUp = pickedUp;
  }
}
