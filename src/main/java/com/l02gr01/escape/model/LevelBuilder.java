package com.l02gr01.escape.model;

import com.l02gr01.escape.model.elements.Exit;
import com.l02gr01.escape.model.elements.Key;
import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.elements.Wall;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LevelBuilder {
  private final List<String> lines;

  public LevelBuilder(int level) throws IOException {
    URL resource = LevelBuilder.class.getResource("/levels/level" + level + ".lvl");
    BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

    lines = readLines(br);
  }

  private List<String> readLines(BufferedReader br) throws IOException {
    List<String> lines = new ArrayList<>();
    for (String line; (line = br.readLine()) != null; )
      lines.add(line);
    return lines;
  }

  public Level createLevel() {
    Level level = new Level(getWidth(), getHeight());

    level.setPlayer(createPlayer());
    level.setWalls(createWalls());
    level.setExit(createExit());
    level.setKeys(createKeys());

    return level;
  }

  private List<Key> createKeys() {
    List<Key> keys = new ArrayList<>();

    for (int y = 0; y < lines.size(); y++) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); x++)
        if (line.charAt(x) == 'K') keys.add(new Key(x, y));
    }

    return keys;
  }

  private Exit createExit() {
    for (int y = 0; y < lines.size(); y++) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); x++) {
        if (line.charAt(x) == 'E') {
          return new Exit(x, y);
        }
      }
    }
    return new Exit(0, 1);
  }

  public int getWidth() {
    int width = 0;
    for (String line : lines)
      width = Math.max(width, line.length());
    return width;
  }

  public int getHeight() {
    return lines.size();
  }

  public List<Wall> createWalls() {
    List<Wall> walls = new ArrayList<>();

    for (int y = 0; y < lines.size(); y++) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); x++)
        if (line.charAt(x) == '#') walls.add(new Wall(x, y));
    }

    return walls;
  }

  protected Player createPlayer() {
    for (int y = 0; y < lines.size(); y++) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); x++)
        if (line.charAt(x) == 'P') return new Player(x, y);
    }
    return null;
  }
}
