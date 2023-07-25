package br.com.ifsul.graphics;

import br.com.ifsul.controller.PokemonController;
import br.com.ifsul.controller.TreinadorController;
import br.com.ifsul.domain.Treinador;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static br.com.ifsul.graphics.assets.MenuAssets.getWallpaper;
import static br.com.ifsul.graphics.assets.PokeHubAssets.getIcon;
import static br.com.ifsul.graphics.audio.MenuAudio.iniciarMusica;
import static br.com.ifsul.graphics.components.MenuComponents.*;

@SuppressWarnings("serial")
public class UIMenu extends JFrame{

   public UIMenu(Long id, TreinadorController treinadorController, JFrame telaInicial, PokemonController controller) {

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

       Treinador treinador = treinadorController.buscarTreinadorService.porId(id);

       this.add(getNameLabel(treinador.getNome()));
       this.add(getSairButton(telaInicial, this));
       this.add(getVerPokemonsButton(treinador, controller));
       this.add(getSprite(treinador.getSexo()));
       this.add(getBatalhaPokemonButton());
       this.add(getCapturarPokemonButton(treinador, controller));
       this.add(getLigarMusica());
       this.add(getPararMusica());
       this.setVisible(true);
   }

}
