package br.com.ifsul.graphics.audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import static javax.sound.sampled.Clip.LOOP_CONTINUOUSLY;

public abstract class CriarTreinadorAudio {

    private static AudioInputStream music = null;
    private static Clip clip;

    static {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }


    public static void iniciarMusica() {
        if(!clip.isOpen()) {
            try {
                music = AudioSystem.getAudioInputStream(new File("src/main/java/br/com/ifsul/graphics/assets/music/criar_treinador_music.wav"));
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
        } else {
            ligarMusica();
        }
    }
    public static void ligarMusica() {
        clip.setMicrosecondPosition(0);
        clip.start();
    }
    public static void pararMusica() {
        clip.stop();
    }


}
