package br.com.ifsul.graphics.menu;

import javax.imageio.ImageIO;
import javax.swing.*;

import br.com.ifsul.service.CriarTreinadorService;

import static br.com.ifsul.graphics.menu.AudioGUI.iniciarMusica;
import static br.com.ifsul.graphics.menu.ButtonGUI.*;
import static br.com.ifsul.graphics.menu.ImageGUI.getIcon;
import static br.com.ifsul.graphics.menu.ImageGUI.getWallpaper;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class UIMenu extends JFrame{

   public UIMenu(CriarTreinadorService service) {	

       BufferedImage icon = getIcon();
       iniciarMusica();

       this.setLayout(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setBounds(250, 100, 800, 500);
       this.setResizable(false);
       this.setIconImage(icon);
       this.setTitle("PokeHub");

       Image wallpaper = getWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);;
       this.setContentPane(new JLabel(new ImageIcon(wallpaper)));

       this.setVisible(true);
       this.add(getCriarTreinadorButton(service));
       this.add(getListarTreinadoresButton());
       this.add(getCapturarPokemonButton());
       this.add(getBatalhaPokemonButton());
       this.add(getLigarMusica());
       this.add(getPararMusica());
   }

}
