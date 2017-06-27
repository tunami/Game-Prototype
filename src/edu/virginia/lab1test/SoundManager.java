package edu.virginia.lab1test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {
    //id, filename
    Map<String, String> sounds;
    
    public SoundManager(){
        sounds = new HashMap<String, String>();
    }
    public void loadSoundEffect(String id, String filename) {
        sounds.put(id, filename);
    }
    public void playSoundEffect(String id) {
        try {
            String filename = sounds.get(id);
            String file = ("resources" + File.separator + filename);
            
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    public void loadMusic(String id, String filename) {
        
    }
    public void playMusic(String id) {
        
    }
}
