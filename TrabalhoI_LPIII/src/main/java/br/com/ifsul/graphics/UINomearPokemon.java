package br.com.ifsul.graphics;

import br.com.ifsul.controller.PokemonController;
import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.graphics.assets.CapturarPokemonAssets;
import br.com.ifsul.graphics.assets.PokeHubAssets;
import br.com.ifsul.graphics.audio.MenuAudio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static br.com.ifsul.graphics.assets.PokeHubAssets.getIcon;
import static br.com.ifsul.graphics.components.CapturarPokemonComponents.getMiniPokemonSprite;

public class UINomearPokemon extends JFrame{

	public UINomearPokemon(PokemonController controller, Treinador treinador, Pokemon pokemon) {
		BufferedImage icon = getIcon();

		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(500, 100, 800, 500);
		this.setResizable(false);
		this.setIconImage(icon);
		this.setTitle("Criar Treinador");

		Image wallpaper = CapturarPokemonAssets.getNomearWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);;
		this.setContentPane(new JLabel(new ImageIcon(wallpaper)));

		JTextField nameField = new JTextField();
		nameField.setBounds(325, 135, 200, 40);
		nameField.setFont(PokeHubAssets.getFont(0,24f));

		JButton OKbutton = new JButton("OK");
		OKbutton.setBounds(627, 395,93, 30);
		OKbutton.setFont(PokeHubAssets.getFont(1,26f));
		OKbutton.setBackground(new Color(222, 214, 89));
		OKbutton.setForeground(new Color(255, 255, 255));
		OKbutton.addActionListener(e -> capturarPokemon(controller, nameField, treinador, pokemon));

		JButton backButton = new JButton("VOLTAR");
		backButton.setBounds(627, 323,93, 30);
		backButton.setFont(PokeHubAssets.getFont(1,20f));
		backButton.setBackground(new Color(222, 214, 89));
		backButton.setForeground(new Color(255, 255, 255));
		backButton.addActionListener(e -> cancelarPokemon(controller, nameField, treinador, pokemon));

		this.add(nameField);
		this.add(OKbutton);
		this.add(backButton);
		this.add(getMiniPokemonSprite(pokemon));
		this.setVisible(true);
	}
	private void capturarPokemon(PokemonController controller,
									JTextField nameField,
									Treinador treinador,
									Pokemon pokemon) {
		controller.capturarPokemonService.capturar(nameField.getText(), treinador, pokemon);
		nameField.setText("");
		this.setVisible(false);
		MenuAudio.ligarMusica();
	}
	private void cancelarPokemon(PokemonController controller,
								 JTextField nameField,
								 Treinador treinador,
								 Pokemon pokemon) {
		controller.capturarPokemonService.capturar(pokemon.getNome().toString(), treinador, pokemon);
		nameField.setText("");
		this.setVisible(false);
		MenuAudio.ligarMusica();
	}

}
