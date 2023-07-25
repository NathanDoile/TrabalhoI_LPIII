package br.com.ifsul.graphics;

import br.com.ifsul.domain.enums.Sexo;
import org.hibernate.engine.jdbc.Size;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static br.com.ifsul.domain.enums.Sexo.MASCULINO;

public abstract class ImageGUI {

    public static Font getFont(int type, float size) {
        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/java/br/com/ifsul/graphics/assets/pokemon_pixel_font.ttf")).deriveFont(type,size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
        return customFont;
    }

    public static BufferedImage getIcon() {
        BufferedImage icon = null;
        try {
            icon = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/icon.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
        return icon;
    }

    public static BufferedImage getWallpaper() {
        BufferedImage wallpaper = null;
        try {
            wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/menu.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }
    
    public static BufferedImage getTreinadorWallpaper() {
        BufferedImage wallpaper = null;
        try {
            wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/criar_treinador.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }

    public static BufferedImage getListarTreinadoresWallpaper() {
        BufferedImage wallpaper = null;
        try {
            wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/lista_treinadores.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }

    public static BufferedImage getSprite1(Sexo sexo) {
        BufferedImage wallpaper = null;
        try {
            if(sexo.equals(MASCULINO)) {
                wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/boy1.png"));
            } else {
                wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/girl1.png"));
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }
    public static BufferedImage getCapturarWallpaper() {
        BufferedImage wallpaper = null;
        try {
            wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/capturar_pokemon.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }

}
