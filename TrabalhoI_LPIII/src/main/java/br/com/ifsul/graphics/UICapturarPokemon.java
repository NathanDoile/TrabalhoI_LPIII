package br.com.ifsul.graphics;

import br.com.ifsul.controller.PokemonController;
import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.graphics.assets.CapturarPokemonAssets;
import br.com.ifsul.graphics.audio.BatalhaAudio;
import br.com.ifsul.util.SortearPokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import static br.com.ifsul.graphics.assets.PokeHubAssets.getIcon;
import static br.com.ifsul.graphics.components.CapturarPokemonComponents.*;

public class UICapturarPokemon extends JFrame{
	
	public UICapturarPokemon(Treinador treinador, PokemonController controller) {
		BufferedImage icon = getIcon();
		BatalhaAudio.iniciarMusicaBatalha();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				BatalhaAudio.pararMusica();
			}
		});

		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(500, 100, 800, 500);
		this.setResizable(false);
		this.setIconImage(icon);
		this.setTitle("PokéHub");

		Image wallpaper = CapturarPokemonAssets.getWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);;
		this.setContentPane(new JLabel(new ImageIcon(wallpaper)));

		Pokemon pokemon = SortearPokemon.sortearPokemon();

		this.add(getPokemonSprite(pokemon));
		this.add(getTreinadorSprite(treinador));
		this.add(getTreinadorLabel(treinador));
		this.add(getPokemonNameLabel(pokemon));
		this.add(getPokemonNivelLabel(pokemon));
		this.add(getCapturarButton(this, controller, treinador, pokemon));
		this.add(getFugirButton(this));
		this.add(getMensagemLabel(pokemon));
		this.add(getLigarMusica());
		this.add(getPararMusica());

		this.setVisible(true);
	   }


}
