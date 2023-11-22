package com.l02gr01.escape.viewer.game;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.elements.Exit;

public class ExitViewer implements ElementViewer<Exit> {

  @Override
  public void draw(Exit exit, GUI gui) {
    gui.drawExit(exit.getPosition(), exit.isOpen());
  }
}
