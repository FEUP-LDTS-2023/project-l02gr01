package com.l02gr01.escape.audio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioManager {

  private static AudioManager audioManager;
  private static final String AUDIO_DIRECTORY = "audio/";
  private static final String BACKGROUND_MUSIC_FILE = "background.wav";

  // Can be used to track long playing sounds and stop them
  private final Set<Clip> activeSounds = new HashSet<>();
  private AudioManager(){}
  public static AudioManager getInstance() {
    if (audioManager == null) {
      audioManager = new AudioManager();
    }
    return audioManager;
  }

  public void playBackgroundMusic() {
    playSound(BACKGROUND_MUSIC_FILE);
  }

  public void playSound(String file) {
    try {
      AudioInputStream audioInputStream =
          AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream(AUDIO_DIRECTORY + file));
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
      clip.start();
      activeSounds.add(clip);
    } catch (Exception ex) {
      System.out.println("ERROR: Could not play sound - " + file);
      ex.printStackTrace();
    }
  }

  public void stopAllSounds() {
    Iterator<Clip> iterator = activeSounds.iterator();
    while (iterator.hasNext()) {
      Clip sound = iterator.next();
      sound.stop();
      iterator.remove();
    }
  }
}
