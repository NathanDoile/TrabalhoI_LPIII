package br.com.ifsul.graphics.assets;

import br.com.ifsul.domain.enums.Sexo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static br.com.ifsul.domain.enums.Sexo.MASCULINO;

public abstract class MenuAssets {

    public static BufferedImage getWallpaper() {
        BufferedImage wallpaper = null;
        try {
            wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/menu_vazio.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }
    public static BufferedImage getSprite(Sexo sexo) {
        BufferedImage wallpaper = null;
        try {
            if(sexo.equals(MASCULINO)) {
                wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/boy2.png"));
            } else {
                wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/girl2.png"));
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }

}
