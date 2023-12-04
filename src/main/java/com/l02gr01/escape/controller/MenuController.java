package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.*;
import com.l02gr01.escape.states.InstructionState;
import com.l02gr01.escape.states.LeaderBoardState;
import com.l02gr01.escape.states.PreGameState;

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
        if (getModel().isSelectedExit()){
          game.setState(null);
        }
        if (getModel().isSelectedStart()) game.setState(new PreGameState(new PreGame()));
        if (getModel().isSelectedInstruction()) game.setState(new InstructionState(new Instruction()));
        if (getModel().isSelectedLeaderboard()) game.setState(new LeaderBoardState(new Leaderboard()));
        break;
      default:
        break;
    }
  }
}
