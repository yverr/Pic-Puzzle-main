package com.example;

import javafx.scene.media.AudioClip;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SoundManager {
    // Yes, this is a hash map, a data structure. Yes, this was necessary. And no, I'm not explaining anything😭🙏🙏🙏
    private static final Map<String, AudioClip> sounds = new HashMap<>();
    private static boolean isMuted = false; 
    private static Clip backgroundMusic; 

    static {
        sounds.put("PlayGame", new AudioClip(new File("demo\\src\\resources\\tracks\\PlayGameClick.wav").toURI().toString()));
        sounds.put("GameMenu", new AudioClip(new File("demo\\src\\resources\\tracks\\gamemenubuttonclick.wav").toURI().toString()));
        sounds.put("Buttons", new AudioClip(new File("demo\\src\\resources\\tracks\\buttonclick.wav").toURI().toString()));
    }

    public static void playSound(String soundName) {
        if (!isMuted && sounds.containsKey(soundName)) {
            sounds.get(soundName).play();
        }
    }

    public static void setMute(boolean mute) {
        isMuted = mute;
        if (backgroundMusic != null) {
            if (isMuted) {
                backgroundMusic.stop();
            } else {
                backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
                backgroundMusic.start();
            }
        }
    }

    public static boolean isMuted() {
        return isMuted;
    }

    public static void playBackgroundMusic() {
        if (!isMuted) {
            try {
                if (backgroundMusic != null && backgroundMusic.isRunning()) {
                    return; // If already playing, do nothing
                }

                File musicFile = new File("demo\\src\\resources\\tracks\\game-music-teste.wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
                backgroundMusic = AudioSystem.getClip();
                backgroundMusic.open(audioStream);
                backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY); // Loop forever

                backgroundMusic.start();
            
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }   
    }

    // Stop background music completely
    public static void stopBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
            backgroundMusic.close();
        }
    }
}
