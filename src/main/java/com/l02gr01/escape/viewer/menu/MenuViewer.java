package com.l02gr01.escape.viewer.menu;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
  public MenuViewer(Menu menu) {
    super(menu);
  }

  @Override
  public void drawElements(GUI gui) {
    gui.drawText(new Position(11, 5), "Menu", "#3333FF");
    for (int i = 0; i < getModel().getNumberEntries(); i++)
      gui.drawText(
          new Position(11, 8 + i),
          getModel().getEntry(i),
          getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
  }
}
