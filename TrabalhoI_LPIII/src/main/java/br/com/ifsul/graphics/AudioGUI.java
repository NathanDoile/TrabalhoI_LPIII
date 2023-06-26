package br.com.ifsul.graphics;

import javax.sound.sampled.*;

import java.io.File;
import java.io.IOException;

import static javax.sound.sampled.Clip.LOOP_CONTINUOUSLY;

public abstract class AudioGUI {

    private static AudioInputStream music = null;

    public static void iniciarMusica() {
        try {
            music = AudioSystem.getAudioInputStream(new File("src/main/java/br/com/ifsul/graphics/assets/music.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(music);
            clip.loop(LOOP_CONTINUOUSLY);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
