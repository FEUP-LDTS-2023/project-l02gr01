package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Instruction;
import com.l02gr01.escape.model.LevelBuilder;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.states.GameState;
import com.l02gr01.escape.states.InstructionState;

import java.io.IOException;
import java.net.URISyntaxException;

public class MenuController extends Controller<Menu> {
  public MenuController(Menu menu) {
    super(menu);
  }

  @Override
  public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
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
        if (getModel().isSelectedInstruction()) game.setState(new InstructionState(new Instruction()));
        break;
      default:
        break;
    }
  }
}
