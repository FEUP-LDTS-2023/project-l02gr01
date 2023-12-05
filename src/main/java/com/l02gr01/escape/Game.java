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

    private Game() throws IOException, URISyntaxException, FontFormatException {
        // Add singleton logic
        this.gui = new LanternaGUI(30, 25);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }
    private void start() throws IOException, URISyntaxException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        gui.close();

    }

    public void setState(State state) {
        this.state = state;
    }

}
