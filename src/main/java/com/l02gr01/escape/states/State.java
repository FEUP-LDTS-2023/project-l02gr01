package com.l02gr01.escape.states;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;

import java.io.IOException;

public abstract class State<T> {

    private final T model;
    public State(T model) {
        this.model = model;
    }


    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        //controller.step(game, action, time);
        //viewer.draw(gui);
    }
}
