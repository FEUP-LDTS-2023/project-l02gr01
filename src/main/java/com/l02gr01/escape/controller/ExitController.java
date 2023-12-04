package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI.ACTION;
import com.l02gr01.escape.model.Level;
import java.io.IOException;

public class ExitController extends GameController {

  public ExitController(Level level) {
    super(level);
  }

  @Override
  public void step(Game game, ACTION action, long time) {

    if(getModel().getKeys().getRemainingKeys() == 0) {
      getModel().getExit().setOpen(true);
    }
  }
}
