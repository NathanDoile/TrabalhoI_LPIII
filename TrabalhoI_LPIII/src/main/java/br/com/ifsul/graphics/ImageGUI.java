package br.com.ifsul.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class ImageGUI {

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
            wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/oi.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }

}
