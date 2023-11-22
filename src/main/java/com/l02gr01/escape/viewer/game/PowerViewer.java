package com.l02gr01.escape.viewer.game;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.elements.powers.Power;

public class PowerViewer implements ElementViewer<Power>{

  @Override
  public void draw(Power power, GUI gui) {
    gui.drawPower(power);
  }
}
