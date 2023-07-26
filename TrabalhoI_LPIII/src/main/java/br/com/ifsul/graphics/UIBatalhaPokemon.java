package br.com.ifsul.graphics;

import br.com.ifsul.controller.PokemonController;
import br.com.ifsul.controller.TreinadorController;
import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.graphics.audio.BatalhaAudio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

import static br.com.ifsul.graphics.assets.BatalhaPokemonAssets.getWallpaper;
import static br.com.ifsul.graphics.assets.PokeHubAssets.getIcon;
import static br.com.ifsul.graphics.components.BatalhaPokemonComponents.*;

public class UIBatalhaPokemon extends JFrame{

	Random random = new Random();

	public UIBatalhaPokemon(Treinador treinador,
							PokemonController pokemonController,
							TreinadorController treinadorController) {
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

		Image wallpaper = getWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);;
		this.setContentPane(new JLabel(new ImageIcon(wallpaper)));

		Treinador adversario = selecionaTreinador(treinadorController,treinador, random);
		Pokemon pokemonAdversario = selecionaPokemon(pokemonController,adversario, random);
		Pokemon pokemonAliado = pokemonController.buscarPokemonService.primeiro(treinador.getId());

		JLabel spriteInimigo = getInimigoSprite(pokemonAdversario);
		JLabel nomeInimigo= getInimigoNameLabel(pokemonAdversario);
		JLabel spriteAliado= getAliadoSprite(pokemonAliado);
		JLabel nomeAliado= getAliadoLabel(pokemonAliado);
		JLabel mensagem= getMensagemLabel(adversario);
		JLabel inimigoLvl = getInimigoNivelLabel(pokemonAdversario);
		JLabel aliadoLvl = getAliadoNivelLabel(pokemonAliado);

		this.add(spriteInimigo);
		this.add(nomeInimigo);
		this.add(spriteAliado);
		this.add(inimigoLvl);
		this.add(aliadoLvl);
		this.add(nomeAliado);
		this.add(mensagem);
		this.add(getBatalharButton());
		this.add(getTrocarButton(
				spriteAliado,
				nomeAliado,
				aliadoLvl,
				mensagem,
				pokemonController,
				treinador));
		this.add(getFugirButton(this));
		this.add(getLigarMusica());
		this.add(getPararMusica());

		this.setVisible(true);
	   }
	private Pokemon selecionaPokemon(PokemonController pokemonController, Treinador treinador, Random random){

		java.util.List<Pokemon> pokemons = pokemonController.buscarPokemonsTreinadorService.porTreinador(treinador);

		return pokemons.get(random.nextInt(pokemons.size()));
	}

	private Treinador selecionaTreinador(TreinadorController treinadorController, Treinador treinador, Random random){

		List<Treinador> treinadores = treinadorController.buscarTreinadoresSemTreinadorService.semTreinador(treinador);

		return treinadores.get(random.nextInt(treinadores.size()));
	}

}
