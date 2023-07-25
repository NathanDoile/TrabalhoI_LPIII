package br.com.ifsul.graphics.assets;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class TelaInicialAssets {

    public static BufferedImage getWallpaper() {
        BufferedImage wallpaper = null;
        try {
            wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/tela_inicial.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }


}
