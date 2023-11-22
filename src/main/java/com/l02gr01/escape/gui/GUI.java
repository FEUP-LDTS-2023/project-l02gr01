package com.l02gr01.escape.gui;

import com.l02gr01.escape.model.Position;
import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawPlayer(Position position);

    void drawText(Position position, String text, String color);
    void drawWall(Position position);

    void drawExit(Position position, boolean locked);

    void drawKey(Position position);

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
