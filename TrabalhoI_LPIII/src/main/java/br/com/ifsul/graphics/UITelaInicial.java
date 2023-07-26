package br.com.ifsul.graphics;

import br.com.ifsul.controller.PokemonController;
import br.com.ifsul.controller.TreinadorController;
import br.com.ifsul.graphics.assets.TelaInicialAssets;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static br.com.ifsul.graphics.assets.PokeHubAssets.getIcon;
import static br.com.ifsul.graphics.audio.TelaInicialAudio.iniciarMusica;
import static br.com.ifsul.graphics.components.TelaInicialComponents.*;

@SuppressWarnings("serial")
public class UITelaInicial extends JFrame{

   public UITelaInicial(
                        TreinadorController treinadorController,
                        PokemonController pokemonController
                        ) {

       BufferedImage icon = getIcon();
       iniciarMusica();

       this.setLayout(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setBounds(250, 100, 800, 500);
       this.setResizable(false);
       this.setIconImage(icon);
       this.setTitle("PokéHub");

       Image wallpaper = TelaInicialAssets.getWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
       this.setContentPane(new JLabel(new ImageIcon(wallpaper)));

       this.add(criarTreinadorButton(this, treinadorController));
       this.add(carregarTreinadorButton(treinadorController, this, pokemonController));
       this.add(ligarMusicaButton());
       this.add(pararMusicaButton());
       this.add(creditosLabel());
       this.setVisible(true);
   }

}
