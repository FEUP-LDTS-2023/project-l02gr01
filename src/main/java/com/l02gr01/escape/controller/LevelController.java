package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.gui.GUI.ACTION;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.states.MenuState;
import java.io.IOException;

public class LevelController extends GameController {
  private final PlayerController playerController;
  private final ExitController exitController;

  public LevelController(Level level) {
    super(level);
    this.playerController = new PlayerController(level);
    this.exitController = new ExitController(level);
  }

  @Override
  public void step(Game game, ACTION action, long time) throws IOException {
    if (action == GUI.ACTION.QUIT || getModel().getPlayer().getHealth() == 0) {
      game.setState(new MenuState(new Menu()));
    } else if (getModel().getExit().getPosition().equals(getModel().getPlayer().getPosition())) {
        game.setState(new MenuState(new Menu()));
    } else {
      playerController.step(game, action, time);
      exitController.step(game, action, time);
    }
  }
}
