package com.l02gr01.escape.viewer.game;

import com.googlecode.lanterna.Symbols;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Element;
import com.l02gr01.escape.model.elements.powers.Power;
import com.l02gr01.escape.viewer.Viewer;
import java.util.List;

import static java.lang.Math.max;

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


    int userhealth = getModel().getPlayer().getHealth();
    if(userhealth < 0){
      userhealth = - userhealth;
    }
    gui.drawText(new Position(0, 0), String.valueOf(Symbols.HEART).repeat(userhealth / 10), "#ff0000");
    gui.drawText(new Position(20, 0), "Bullets "+ getModel().getPlayer().getBulletsAvailable(), "#FFFFFF");

    if (getModel().getLevelNumber() == 1) {
      gui.drawText(new Position(1,20), String.valueOf(Symbols.CLUB), "#FFD700");
      gui.drawText(new Position(3,20), "- pick all the keys!", "#FFFFFF");
      gui.drawText(new Position(1,21), String.valueOf(Symbols.CLUB), "#FF00FF");
      gui.drawText(new Position(3,21), "- super-vision!", "#FFFFFF");
    }

    if (getModel().getLevelNumber() == 2) {
      gui.drawText(new Position(1,19), String.valueOf(Symbols.CLUB), "#03fbff");
      gui.drawText(new Position(3,19), "- freeze time!", "#FFFFFF");
      gui.drawText(new Position(1,20), String.valueOf(Symbols.INVERSE_WHITE_CIRCLE), "#a894ff");
      gui.drawText(new Position(3,20), "- shield up!", "#FFFFFF");
      gui.drawText(new Position(1,21), String.valueOf(Symbols.DIAMOND), "#116909");
      gui.drawText(new Position(3,21), "- beware: Troll!", "#FFFFFF");
    }
  }

  private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
    for (T element : elements)
      drawElement(gui, element, viewer);
  }

  private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
    int n = 3;
    if (getModel().getPlayer().getActivePowers().containsKey(Power.PowerType.SUPER_VISION)) {
      n = max(getModel().getHeight(), getModel().getWidth());
    }
    if(element.getPosition().iswithindistance(getModel().getPlayer().getPosition(), n)){
      viewer.draw(element, gui);
    }
  }
}