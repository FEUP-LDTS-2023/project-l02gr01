package com.l02gr01.escape.gui;

import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import com.l02gr01.escape.model.elements.powers.Power;
import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawPlayer(Player position);

    void drawText(Position position, String text, String color);
    void drawWall(Position position);

    void drawExit(Position position, boolean locked);

    void drawKey(Position position);

    void drawEnemy(Enemy enemy);

    void drawBullet(Position position);

    void drawPower(Power power);

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, TAB, SELECT}
}
