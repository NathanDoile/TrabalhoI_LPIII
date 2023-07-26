package br.com.ifsul.graphics.components;

import br.com.ifsul.controller.PokemonController;
import br.com.ifsul.controller.TreinadorController;
import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.graphics.UIEscolherPokemon;
import br.com.ifsul.graphics.UIResultado;
import br.com.ifsul.graphics.assets.BatalhaPokemonAssets;
import br.com.ifsul.graphics.assets.CapturarPokemonAssets;
import br.com.ifsul.graphics.assets.PokeHubAssets;
import br.com.ifsul.graphics.audio.BatalhaAudio;
import br.com.ifsul.graphics.audio.MenuAudio;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public abstract class BatalhaPokemonComponents {

    public static JLabel getInimigoSprite(Pokemon pokemon) {
        JLabel sprite = new JLabel();
        sprite.setBounds(500, 15,200,200);
        Image spriteImg = CapturarPokemonAssets.getPokemonSprite(pokemon).getScaledInstance(sprite.getWidth(), sprite.getHeight(), Image.SCALE_SMOOTH);
        sprite.setIcon(new ImageIcon(spriteImg));
        return sprite;
    }

    public static JLabel getAliadoSprite(Pokemon pokemon) {
        JLabel sprite = new JLabel();
        sprite.setBounds(35, 120,200,200);
        Image spriteImg = BatalhaPokemonAssets.getPokemonAliadoSprite(pokemon).getScaledInstance(sprite.getWidth(), sprite.getHeight(), Image.SCALE_SMOOTH);
        sprite.setIcon(new ImageIcon(spriteImg));
        return sprite;
    }

    public static JLabel getInimigoNameLabel(Pokemon pokemon) {
        JLabel label = new JLabel(pokemon.getApelido());
        label.setBounds(55, 7, 250, 100);
        label.setFont(PokeHubAssets.getFont(0,32f));
        label.setForeground(new Color(0, 0, 0));
        return label;
    }

    public static JLabel getInimigoNivelLabel(Pokemon pokemon) {
        JLabel label = new JLabel("Lv. "+pokemon.getLevel());
        label.setBounds(270, 7, 250, 100);
        label.setFont(PokeHubAssets.getFont(0,32f));
        label.setForeground(new Color(0, 0, 0));
        return label;
    }

    public static JLabel getAliadoNivelLabel(Pokemon pokemon) {
        JLabel label = new JLabel("Lv. "+pokemon.getLevel());
        label.setBounds(675, 210, 250, 40);
        label.setFont(PokeHubAssets.getFont(0,32f));
        label.setForeground(new Color(0, 0, 0));
        return label;
    }

    public static JLabel getMensagemLabel(Treinador treinador) {
        JLabel label = new JLabel(treinador.getNome()+" te chamou para batalhar!");
        label.setBounds(35, 300, 400, 100);
        label.setFont(PokeHubAssets.getFont(0,34f));
        label.setForeground(new Color(224, 224, 224));
        return label;
    }

    public static JLabel getAliadoLabel(Pokemon pokemon) {
        JLabel label = new JLabel(pokemon.getApelido());
        label.setBounds(460, 210, 350, 40);
        label.setFont(PokeHubAssets.getFont(0,34f));
        label.setForeground(new Color(0, 0, 0));
        return label;
    }

    public static JButton getTrocarButton(JLabel spriteAliado,
                                            JLabel nomeAliado,
                                            JLabel mensagem,
                                            JLabel lvlAliado,
                                            PokemonController controller,
                                            Treinador treinador) {
        JButton button = new JButton("POKEMON");
        button.setBounds(450, 385, 150, 40);
        button.setFont(PokeHubAssets.getFont(1,24f));
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(0, 0, 0));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> abrirEscolherPokemon(
                controller,
                treinador,
                spriteAliado,
                nomeAliado,
                mensagem,
                lvlAliado
        ));
        return button;
    }

    public static JButton getBatalharButton(
    		TreinadorController treinadorController,
    		JFrame telaBatalha,
    		Treinador treinador,
    		Pokemon pokemonTreinador,
    		Pokemon pokemonAdversario
    		) {
        JButton button = new JButton("BATALHAR");
        button.setBounds(450, 340, 150, 40);
        button.setFont(PokeHubAssets.getFont(1,24f));
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(0, 0, 0));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> batalhar(
        		treinadorController,
        		telaBatalha,
        		treinador,
        		pokemonTreinador,
        		pokemonAdversario
        		));
        return button;
    }

    public static JButton getFugirButton(JFrame tela) {
        JButton button = new JButton("DESISTIR");
        button.setBounds(625, 340, 150, 40);
        button.setFont(PokeHubAssets.getFont(1,24f));
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(0, 0, 0));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> fugir(tela));
        return button;
    }

    public static JButton getLigarMusica() {
        JButton button = new JButton("Ligar Musica");
        button.setBounds(675, 5, 100, 20);
        button.setFont(PokeHubAssets.getFont(1,12f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> BatalhaAudio.ligarMusica());
        return button;
    }
    public static JButton getPararMusica() {
        JButton button = new JButton("Parar Musica");
        button.setBounds(675, 28, 100, 20);
        button.setFont(PokeHubAssets.getFont(1,12f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> BatalhaAudio.pararMusica());
        return button;
    }

    private static void abrirEscolherPokemon(PokemonController pokemonController,
                                             Treinador treinador,
                                             JLabel spriteAliado,
                                             JLabel nomeAliado,
                                             JLabel mensagem,
                                             JLabel lvlAliado) {
        new UIEscolherPokemon(
                pokemonController,
                treinador,
                spriteAliado,
                nomeAliado,
                mensagem,
                lvlAliado);
    }
    
    private static void batalhar(
    		TreinadorController treinadorController,
    		JFrame telaBatalha,
    		Treinador treinador,
    		Pokemon pokemonTreinador,
    		Pokemon pokemonAdversario
    		) {
    	Treinador vencedor = treinadorController.batalhaService.batalhar(pokemonTreinador,pokemonAdversario);
    	if(Objects.equals(vencedor.getId(), treinador.getId())) {
        	new UIResultado("Voce venceu!!");
    	} else {
    		new UIResultado("Voce perdeu...");
    	}
    	BatalhaAudio.pararMusica();
    	telaBatalha.setVisible(false);
    }


    private static void fugir(JFrame tela) {
        BatalhaAudio.pararMusica();
        MenuAudio.ligarMusica();
        tela.setVisible(false);
    }

}
