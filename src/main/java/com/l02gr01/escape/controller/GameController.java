package com.l02gr01.escape.controller;

import com.l02gr01.escape.model.Level;

public abstract class GameController extends Controller<Level> {
  public GameController(Level level) {
    super(level);
  }
}