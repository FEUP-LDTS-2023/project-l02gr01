package com.l02gr01.escape.model;

import com.l02gr01.escape.model.elements.*;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import com.l02gr01.escape.model.elements.enemies.StrongTroll;
import com.l02gr01.escape.model.elements.enemies.Troll;
import com.l02gr01.escape.model.elements.powers.Power;
import com.l02gr01.escape.model.elements.powers.Shield;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class LevelBuilder {
  private final List<String> lines;
  private final int levelNumber;

  public LevelBuilder(int levelNumber) throws IOException, URISyntaxException {
    this.levelNumber = levelNumber;
    URL resource = LevelBuilder.class.getResource("/levels/level" + levelNumber + ".lvl");
      assert resource != null;
      BufferedReader br = Files.newBufferedReader(Paths.get(resource.toURI()), Charset.defaultCharset());
    lines = readLines(br);
  }

  private List<String> readLines(BufferedReader br) throws IOException {
    List<String> lines = new ArrayList<>();
    for (String line; (line = br.readLine()) != null; )
      lines.add(line);
    return lines;
  }

  public Level createLevel() {
    Level level = new Level(getWidth(), getHeight(), levelNumber);

    level.setPlayer(createPlayer());
    level.setWalls(createWalls());
    level.setExit(createExit());
    level.setKeys(createKeys());
    level.setEnemies(createEnemies());
    level.setPowers(createPowers());

    return level;
  }

  private List<Power> createPowers() {
    List<Power> powers = new ArrayList<>();
    for (int y = 0; y < lines.size(); y++) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); x++)
        if (line.charAt(x) == 'S') powers.add(new Shield(x, y));
    }
    return powers;
  }

  private Keys createKeys() {
    Keys keys = new Keys();

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

  private List<Enemy> createEnemies() {
    List<Enemy> enemies = new ArrayList<>();
    for (int y = 0; y < lines.size(); y++) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); x++) {
        switch (line.charAt(x)) {
          case 'T':
            enemies.add(new Troll(x, y));
            break;
          case 'X':
            enemies.add(new StrongTroll(x, y));
            break;
        }
      }
    }
    return enemies;
  }
}
