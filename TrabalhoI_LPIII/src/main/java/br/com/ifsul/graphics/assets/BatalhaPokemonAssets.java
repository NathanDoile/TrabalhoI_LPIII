package br.com.ifsul.graphics.assets;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.enums.Sexo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static br.com.ifsul.domain.enums.Sexo.MASCULINO;

public abstract class BatalhaPokemonAssets {

    public static BufferedImage getWallpaper() {
        BufferedImage wallpaper = null;
        try {
            wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/arena.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }

    public static BufferedImage getPokemonSprite(Pokemon pokemon) {
        BufferedImage wallpaper = null;
        String nome = pokemon.getNome().toString();
        try {
            wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/pokemon/"+ nome +".png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }

    public static BufferedImage getPokemonAliadoSprite(Pokemon pokemon) {
        BufferedImage wallpaper = null;
        String nome = pokemon.getNome().toString();
        try {
            wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/pokemon/"+ nome +"_2.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }

    public static BufferedImage getTreinadorSprite(Sexo sexo) {
        BufferedImage wallpaper = null;
        try {
            if(sexo.equals(MASCULINO)) {
                wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/boy3.png"));
            } else {
                wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/girl3.png"));
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }

    public static BufferedImage getInimigoSprite(Sexo sexo) {
        BufferedImage wallpaper = null;
        try {
            if(sexo.equals(MASCULINO)) {
                wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/boy4.png"));
            } else {
                wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/girl4.png"));
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }
}
