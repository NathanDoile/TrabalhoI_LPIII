package br.com.ifsul.graphics;

import br.com.ifsul.controller.PokemonController;
import br.com.ifsul.controller.TreinadorController;
import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.graphics.assets.PokeHubAssets;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static br.com.ifsul.graphics.assets.MenuAssets.getWallpaper;
import static br.com.ifsul.graphics.assets.PokeHubAssets.getIcon;
import static br.com.ifsul.graphics.audio.MenuAudio.iniciarMusica;
import static br.com.ifsul.graphics.components.MenuComponents.*;

@SuppressWarnings("serial")
public class UIResultado extends JFrame{

   public UIResultado(String text) {

       BufferedImage icon = getIcon();

       this.setLayout(null);
       this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       this.setBounds(250, 100, 200, 100);
       this.setResizable(false);
       this.setIconImage(icon);
       this.setTitle("PokeHub");

       JLabel label = new JLabel(text);
       label.setBounds(25, 10, 150, 50);
       label.setFont(PokeHubAssets.getFont(0,24f));
       label.setForeground(new Color(0, 0, 0));
       
       this.add(label);
       this.setVisible(true);
   }

}
