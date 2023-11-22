package com.l02gr01.escape.viewer.game;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.elements.Key;

public class KeyViewer implements ElementViewer<Key> {

  @Override
  public void draw(Key key, GUI gui) {
    if (!key.isPickedUp()) {
      gui.drawKey(key.getPosition());
    }
  }
}
