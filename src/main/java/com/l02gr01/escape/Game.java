package com.l02gr01.escape;

import gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        // Add singleton logic
        this.gui = new LanternaGUI(20, 20);


    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }
    private void start() throws IOException {
        // start the gui
    }

}
