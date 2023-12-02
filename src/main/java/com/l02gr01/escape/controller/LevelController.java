package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.gui.GUI.ACTION;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.LevelBuilder;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.model.history.History;
import com.l02gr01.escape.model.history.event.Win;
import com.l02gr01.escape.states.GameState;
import com.l02gr01.escape.states.MenuState;
import java.io.IOException;
import java.net.URISyntaxException;

public class LevelController extends GameController {
  private final PlayerController playerController;
  private final ExitController exitController;
  
  private final EnemyController enemyController;
  private static final int MAX_LEVEL = 3;

  public LevelController(Level level) {
    super(level);
    this.playerController = new PlayerController(level);
    this.exitController = new ExitController(level);
    this.enemyController = new EnemyController(level);
  }

  @Override
  public void step(Game game, ACTION action, long time) throws IOException, URISyntaxException {
    if (action == GUI.ACTION.QUIT || getModel().getPlayer().getHealth() == 0) {
      game.setState(new MenuState(new Menu()));
    } else if (getModel().getExit().getPosition().equals(getModel().getPlayer().getPosition())) {
      if (getModel().getLevelNumber() == MAX_LEVEL) {
        long finaltime = time - History.getInstance().getStartTime();
        History.getInstance().push(new Win("Filipe", finaltime, MAX_LEVEL));
        game.setState(new MenuState(new Menu()));
      } else {
        game.setState(new GameState(new LevelBuilder(getModel().getLevelNumber() + 1)));
      }
    } else {
      playerController.step(game, action, time);
      exitController.step(game, action, time);
      enemyController.step(game, action, time);
    }
  }
}
