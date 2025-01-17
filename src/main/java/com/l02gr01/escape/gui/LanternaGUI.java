package com.l02gr01.escape.gui;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.l02gr01.escape.gui.text.TextManipulator;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import com.l02gr01.escape.model.elements.powers.Power;
import com.l02gr01.escape.model.elements.powers.Power.PowerType;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI{

    private final Screen screen;


    // Inspired on code by AOR

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
      return terminalFactory.createTerminal();
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/font.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 40);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF || keyStroke.getKeyType() == KeyType.Escape) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        if (keyStroke.getKeyType() == KeyType.Backspace) {
            TextManipulator.getInstance().removeCharacter();
        }
        if (keyStroke.getKeyType() == KeyType.Character) {
            Character key = keyStroke.getCharacter();
            if (key >= 'a' && key <= 'z') {
                TextManipulator.getInstance().addCharacter(key);
            }
        }
        if (keyStroke.getKeyType() == KeyType.Tab) return ACTION.TAB;

        return ACTION.NONE;
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.setCharacter(x, y + 1, c);
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public void drawPlayer(Player player) {
        String playerColor = "#FFD700";
        if (player.getActivePowers().containsKey(PowerType.SHIELD)) {
            playerColor = "#a894ff";
        }
        drawCharacter(player.getPosition().getX(), player.getPosition().getY(), Symbols.FACE_WHITE, playerColor);
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), Symbols.BLOCK_SOLID, "#3333FF");
    }

    @Override
    public void drawKey(Position position) {
        drawCharacter(position.getX(), position.getY(), Symbols.CLUB, "#ffe100");
    }

    @Override
    public void drawEnemy(Enemy enemy) {
        drawCharacter(enemy.getPosition().getX(), enemy.getPosition().getY(), Symbols.DIAMOND, enemy.getColor());
    }

    @Override
    public void drawPower(Power power) {
        drawCharacter(power.getPosition().getX(), power.getPosition().getY(), power.getSymbol(), power.getColor());
    }

    @Override
    public void drawBullet(Position position){
        String exitColor = "#636361";
        drawCharacter(position.getX(), position.getY(), '*', exitColor);
    }

    @Override
    public void drawExit(Position position, boolean isOpen) {
        String exitColor = "#5c012e";
        if (isOpen) {
            exitColor = "#1bf207";
        }
        drawCharacter(position.getX(), position.getY(), Symbols.BLOCK_SPARSE, exitColor);
    }



}
