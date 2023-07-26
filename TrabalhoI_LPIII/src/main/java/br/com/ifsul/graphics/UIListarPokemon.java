package br.com.ifsul.graphics;

import br.com.ifsul.controller.PokemonController;
import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.graphics.assets.PokeHubAssets;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

import static br.com.ifsul.graphics.assets.PokeHubAssets.getIcon;

public class UIListarPokemon extends JFrame{

	private DefaultListModel<String> dadosLista = new DefaultListModel<>();
	private JList<String> lista = new JList<>(dadosLista);

	public UIListarPokemon(PokemonController pokemonController,
						   Treinador treinador) {

		BufferedImage icon = getIcon();

		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(500, 100, 800, 500);
		this.setResizable(false);
		this.setIconImage(icon);
		this.setTitle("PokéHub");

		Image wallpaper = PokeHubAssets.getListarPokemonWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);;
		this.setContentPane(new JLabel(new ImageIcon(wallpaper)));
		lista.addListSelectionListener(evt -> {});

		listarTreinadores(pokemonController, treinador);
		JScrollPane painel = new JScrollPane(lista);
		painel.setBounds(265,130,505,325);
		painel.setFont(PokeHubAssets.getFont(1,28f));

		this.add(painel);
		this.setVisible(true);
	   }

	   private void listarTreinadores(PokemonController pokemonController, Treinador treinador) {
		List<Pokemon> pokemonList = pokemonController.listarPokemonService.porTreinador(treinador.getId());

		for(int i=0;i<pokemonList.size();i++) {

			StringBuilder info = new StringBuilder();
			info.append("<html>");
			info.append(String.format("<p>%d. %s - %s</p>", pokemonList.get(i).getId(), pokemonList.get(i).getNome().toString(), pokemonList.get(i).getApelido()));
			info.append("</html>");

			dadosLista.addElement(info.toString());
		}
	   }

}
