package br.com.ifsul.graphics;

import javax.swing.*;

import br.com.ifsul.service.CriarTreinadorService;
import br.com.ifsul.service.ListarTreinadoresService;

import static br.com.ifsul.graphics.AudioGUI.iniciarMusica;
import static br.com.ifsul.graphics.ButtonGUI.*;
import static br.com.ifsul.graphics.ImageGUI.getIcon;
import static br.com.ifsul.graphics.ImageGUI.getWallpaper;

import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class UIMenu extends JFrame{

   public UIMenu(CriarTreinadorService criarTreinadorService, ListarTreinadoresService listarTreinadores) {

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

       this.add(getCriarTreinadorButton(criarTreinadorService));
       this.add(getListarTreinadoresButton(listarTreinadores));
       this.add(getCapturarPokemonButton());
       this.add(getBatalhaPokemonButton());
       this.add(getLigarMusica());
       this.add(getPararMusica());
       this.setVisible(true);
   }

}
