package org.academiadecodigo.bootcamp;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;



public class Sound {

    private Clip clip;
    private URL soundURL;

    public Sound(String path) {
        initClip(path);
    }

    /**
     * Plays the clip from the point it was stopped or from start if passed with the fromStart argument false or true
     * @param fromStart should be true if want to replay the sound from the start or false otherwise
     */
    public void play(boolean fromStart) {

        if (fromStart) {
            clip.setFramePosition(0);
        }
        clip.start();
    }

    public void stop() {

        clip.stop();
    }

    public void close() {

        clip.close();
    }

    public void setLoop(int times) {
        clip.loop(times);
    }

    public void reOpen() {

        AudioInputStream inputStream = null;

        try {

            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip.open(inputStream);

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void initClip(String path) {

        soundURL = Sound.class.getResource(path); //if loading from jar
        AudioInputStream inputStream = null;

        try {

            if (soundURL == null) {
                File file = new File(path);
                soundURL = file.toURI().toURL(); //if executing on intellij
            }

            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(inputStream);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
















/*public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {

        soundURL[0] = getClass().getResource("/Sounds/death.wav");
        soundURL[1] = getClass().getResource("/Sounds/lasergun.wav");
        soundURL[2] = getClass().getResource("/Sounds/background2.wav");
        soundURL[3] = getClass().getResource("/Sounds/hit.wav");
        soundURL[4] = getClass().getResource("/Sounds/win2.wav");
        soundURL[5] = getClass().getResource("/Sounds/death2.wav");


    }


        public void setFile ( int i){


            try {
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
                clip = AudioSystem.getClip();
                clip.open(ais);

            } catch (Exception e) {

            }
        }

        public void play () {
            clip.start();

        }

        public void loop () {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }

        public void stop () {
            clip.stop();

        }

        public void playMusic ( int i){
            setFile(i);
            play();
            loop();


        }
        public void playSoundEffect ( int i){
            setFile(i);
            play();
        }
        public void StopSound () {
            stop();

        }
    }*/