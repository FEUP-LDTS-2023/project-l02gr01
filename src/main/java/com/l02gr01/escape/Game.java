package com.l02gr01.escape;

import com.l02gr01.escape.gui.LanternaGUI;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.states.MenuState;
import com.l02gr01.escape.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;

    private State state;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        // Add singleton logic
        this.gui = new LanternaGUI(20, 20);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }
    private void start() throws IOException {
        // start the gui

    }

}
