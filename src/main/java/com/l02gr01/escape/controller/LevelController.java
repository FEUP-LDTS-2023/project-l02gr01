package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.gui.GUI.ACTION;
import com.l02gr01.escape.model.EndGame;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.LevelBuilder;
import com.l02gr01.escape.model.history.History;
import com.l02gr01.escape.model.history.event.Loss;
import com.l02gr01.escape.model.history.event.Win;
import com.l02gr01.escape.states.EndGameState;
import com.l02gr01.escape.states.GameState;
import java.io.IOException;
import java.net.URISyntaxException;

public class LevelController extends GameController {
  private final PlayerController playerController;
  private final ExitController exitController;
  
  private final EnemyController enemyController;
  private static final int MAX_LEVEL = 4;

  private final BulletController bulletController;

  public LevelController(Level level) {
    super(level);
    this.playerController = new PlayerController(level);
    this.exitController = new ExitController(level);
    this.enemyController = new EnemyController(level);
    this.bulletController = new BulletController(level);
  }

  @Override
  public void step(Game game, ACTION action, long time) throws IOException, URISyntaxException {
    if (action == GUI.ACTION.QUIT || getModel().getPlayer().getHealth() <= 0) {
      // The user either quited or got 0 health. It's considered game "lost"

      long finalTime = time - History.getInstance().getStartTime();
      History.getInstance().push(new Loss(History.getInstance().getUsername(), finalTime, getModel().getLevelNumber()));
      game.setState(new EndGameState(new EndGame(getModel().getLevelNumber(), (int) finalTime)));

    } else if (getModel().getExit().getPosition().equals(getModel().getPlayer().getPosition())) {

      if (getModel().getLevelNumber() == MAX_LEVEL) {
        // If reached max level, user won!

        long finalTime = time - History.getInstance().getStartTime();
        History.getInstance().push(new Win(History.getInstance().getUsername(), finalTime, getModel().getLevelNumber()));
        game.setState(new EndGameState(new EndGame(getModel().getLevelNumber(), (int) finalTime)));

      } else {
        // Else, it just moved to the next level

        game.setState(new GameState(new LevelBuilder(getModel().getLevelNumber() + 1)));
      }

    } else {
      playerController.step(game, action, time);
      exitController.step(game, action, time);
      enemyController.step(game, action, time);
      bulletController.step(game, action, time);
    }
  }
}
