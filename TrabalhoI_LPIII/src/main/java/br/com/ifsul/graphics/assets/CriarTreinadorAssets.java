package br.com.ifsul.graphics.assets;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class CriarTreinadorAssets {

    public static BufferedImage getConversaWallpaper() {
        BufferedImage wallpaper = null;
        try {
            wallpaper = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/professor_conversa.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return wallpaper;
    }

    public static Icon getSetinhaDireita(JButton button) {
        BufferedImage iconImage = null;
        try {
            iconImage = ImageIO.read(new File("src/main/java/br/com/ifsul/graphics/assets/image/setinha_direita.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        Icon icon = new ImageIcon(iconImage.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH));
        return icon;
    }
}
