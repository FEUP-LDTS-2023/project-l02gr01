package com.l02gr01.escape.viewer.game;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.elements.Element;
import com.l02gr01.escape.viewer.Viewer;
import java.util.List;

public class GameViewer extends Viewer<Level> {
  public GameViewer(Level Level) {
    super(Level);
  }

  @Override
  public void drawElements(GUI gui) {
    drawElements(gui, getModel().getWalls(), new WallViewer());
    drawElement(gui, getModel().getPlayer(), new PlayerViewer());
  }

  private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
    for (T element : elements)
      drawElement(gui, element, viewer);
  }

  private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
    viewer.draw(element, gui);
  }
}