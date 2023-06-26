package br.com.ifsul.graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static br.com.ifsul.graphics.AudioGUI.iniciarMusica;
import static br.com.ifsul.graphics.ButtonGUI.*;
import static br.com.ifsul.graphics.ImageGUI.getIcon;
import static br.com.ifsul.graphics.ImageGUI.getWallpaper;

public abstract class Screen {

    public Screen() {
        this.inicializar();
    }

    public static void main(String[] args) {
        inicializar();
    }

   public static void inicializar() {

       BufferedImage icon = getIcon();
       iniciarMusica();

       JFrame janela = new JFrame();
       janela.setLayout(null);
       janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       janela.setBounds(250, 100, 800, 500);
       janela.setResizable(false);
       janela.setIconImage(icon);
       janela.setTitle("PokeHub");

       Image wallpaper = getWallpaper().getScaledInstance(janela.getWidth(), janela.getHeight(), Image.SCALE_SMOOTH);;
       janela.setContentPane(new JLabel(new ImageIcon(wallpaper)));

       JLabel label = new JLabel();
       label.setText("Oiii");
       label.setFont(new Font("Calibri", Font.BOLD, 120));
       label.setForeground(Color.white);
       label.setHorizontalTextPosition(JLabel.CENTER);



       janela.setVisible(true);
       janela.add(label);
       janela.add(getCriarTreinadorButton());
       janela.add(getListarTreinadoresButton());
       janela.add(getCapturarPokemonButton());
       janela.add(getBatalhaPokemonButton());
       janela.add(getLigarMusica());
       janela.add(getPararMusica());
   }

}
