package com.l02gr01.escape.viewer.game;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Element;
import com.l02gr01.escape.viewer.Viewer;
import java.util.List;

public class GameViewer extends Viewer<Level> {
  public GameViewer(Level level) {
    super(level);
  }

  @Override
  public void drawElements(GUI gui) {
    drawElements(gui, getModel().getPowers(), new PowerViewer());
    drawElements(gui, getModel().getWalls(), new WallViewer());
    drawElements(gui, getModel().getKeys().getList(), new KeyViewer());
    drawElement(gui, getModel().getExit(), new ExitViewer());
    drawElements(gui, getModel().getEnemies(), new EnemyViewer());
    drawElement(gui, getModel().getPlayer(), new PlayerViewer());
    drawElements(gui, getModel().getBullets(), new BulletViewer());

    gui.drawText(new Position(0, 0), "Health: " + getModel().getPlayer().getHealth(), "#FFD700");
  }

  private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
    for (T element : elements)
      drawElement(gui, element, viewer);
  }

  private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
    //if(element.getPosition().iswithindistance(getModel().getPlayer().getPosition(), 3)){
      viewer.draw(element, gui);
    //}
  }
}