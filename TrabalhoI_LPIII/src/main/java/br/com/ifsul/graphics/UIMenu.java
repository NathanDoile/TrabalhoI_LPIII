package br.com.ifsul.graphics;

import br.com.ifsul.domain.Treinador;
import br.com.ifsul.service.BuscarTreinadorService;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static br.com.ifsul.graphics.assets.MenuAssets.getWallpaper;
import static br.com.ifsul.graphics.assets.PokeHubAssets.getIcon;
import static br.com.ifsul.graphics.audio.MenuAudio.iniciarMusica;
import static br.com.ifsul.graphics.components.MenuComponents.*;

@SuppressWarnings("serial")
public class UIMenu extends JFrame{

   public UIMenu(Long id, BuscarTreinadorService buscarTreinadorService, JFrame telaInicial) {

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

       Treinador treinador = buscarTreinadorService.porId(id);

       this.add(getNameLabel(treinador.getNome()));
       this.add(getSairButton(telaInicial, this));
       this.add(getVerPokemonsButton());
       this.add(getSprite(treinador.getSexo()));
       this.add(getBatalhaPokemonButton());
       this.add(getCapturarPokemonButton());
       this.add(getLigarMusica());
       this.add(getPararMusica());
       this.setVisible(true);
   }

}
