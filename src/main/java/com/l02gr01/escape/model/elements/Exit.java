package com.l02gr01.escape.model.elements;

public class Exit extends Element {

  private boolean isOpen = false;

  public Exit(int x, int y) {
    super(x, y);
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void setOpen(boolean open) {
    isOpen = open;
  }
}
