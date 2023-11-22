package com.l02gr01.escape.viewer.game;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.elements.enemies.Enemy;

public class EnemyViewer implements ElementViewer<Enemy>{

  @Override
  public void draw(Enemy enemy, GUI gui) {
    gui.drawEnemy(enemy);
  }
}
