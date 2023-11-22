package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.LevelBuilder;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.states.GameState;
import java.io.IOException;

public class MenuController extends Controller<Menu> {
  public MenuController(Menu menu) {
    super(menu);
  }

  @Override
  public void step(Game game, GUI.ACTION action, long time) throws IOException {
    switch (action) {
      case UP:
        getModel().previousEntry();
        break;
      case DOWN:
        getModel().nextEntry();
        break;
      case SELECT:
        if (getModel().isSelectedExit()) game.setState(null);
        if (getModel().isSelectedStart()) game.setState(new GameState(new LevelBuilder(1)));
    }
  }
}
