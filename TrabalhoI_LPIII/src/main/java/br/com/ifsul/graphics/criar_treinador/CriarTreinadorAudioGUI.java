package br.com.ifsul.graphics.criar_treinador;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import static javax.sound.sampled.Clip.LOOP_CONTINUOUSLY;

public abstract class CriarTreinadorAudioGUI {

    private static AudioInputStream music = null;
    private static Clip clip2;

    static {
        try {
            clip2 = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }


    public static void iniciarMusica() {
        try {
            music = AudioSystem.getAudioInputStream(new File("src/main/java/br/com/ifsul/graphics/assets/music.wav"));
            clip2.open(music);
            clip2.loop(LOOP_CONTINUOUSLY);
            clip2.start();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void ligarMusica() {
        clip2.start();
    }
    public static void pararMusica() {
        clip2.stop();
    }


}
