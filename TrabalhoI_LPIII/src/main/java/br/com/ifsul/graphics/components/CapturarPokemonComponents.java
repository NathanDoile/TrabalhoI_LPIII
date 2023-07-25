package br.com.ifsul.graphics.components;

import br.com.ifsul.controller.PokemonController;
import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.graphics.UINomearPokemon;
import br.com.ifsul.graphics.assets.CapturarPokemonAssets;
import br.com.ifsul.graphics.assets.PokeHubAssets;
import br.com.ifsul.graphics.audio.BatalhaAudio;
import br.com.ifsul.graphics.audio.MenuAudio;

import javax.swing.*;
import java.awt.*;

public abstract class CapturarPokemonComponents {

    public static JLabel getPokemonSprite(Pokemon pokemon) {
        JLabel sprite = new JLabel();
        sprite.setBounds(500, 15,200,200);
        Image spriteImg = CapturarPokemonAssets.getPokemonSprite(pokemon).getScaledInstance(sprite.getWidth(), sprite.getHeight(), Image.SCALE_SMOOTH);;
        sprite.setIcon(new ImageIcon(spriteImg));
        return sprite;
    }

    public static JLabel getMiniPokemonSprite(Pokemon pokemon) {
        JLabel sprite = new JLabel();
        sprite.setBounds(125, 80,100,100);
        Image spriteImg = CapturarPokemonAssets.getPokemonSprite(pokemon).getScaledInstance(sprite.getWidth(), sprite.getHeight(), Image.SCALE_SMOOTH);;
        sprite.setIcon(new ImageIcon(spriteImg));
        return sprite;
    }

    public static JLabel getTreinadorSprite(Treinador treinador) {
        JLabel sprite = new JLabel();
        sprite.setBounds(35, 120,200,200);
        Image spriteImg = CapturarPokemonAssets.getTreinadorSprite(treinador.getSexo()).getScaledInstance(sprite.getWidth(), sprite.getHeight(), Image.SCALE_SMOOTH);;
        sprite.setIcon(new ImageIcon(spriteImg));
        return sprite;
    }

    public static JLabel getPokemonNameLabel(Pokemon pokemon) {
        JLabel label = new JLabel(pokemon.getNome().toString());
        label.setBounds(55, 7, 250, 100);
        label.setFont(PokeHubAssets.getFont(0,32f));
        label.setForeground(new Color(0, 0, 0));
        return label;
    }

    public static JLabel getPokemonNivelLabel(Pokemon pokemon) {
        JLabel label = new JLabel("Lv. "+pokemon.getLevel());
        label.setBounds(270, 7, 250, 100);
        label.setFont(PokeHubAssets.getFont(0,32f));
        label.setForeground(new Color(0, 0, 0));
        return label;
    }

    public static JLabel getMensagemLabel(Pokemon pokemon) {
        JLabel label = new JLabel("Um "+pokemon.getNome().toString()+" selvagem apareceu!");
        label.setBounds(35, 300, 400, 100);
        label.setFont(PokeHubAssets.getFont(0,34f));
        label.setForeground(new Color(224, 224, 224));
        return label;
    }

    public static JLabel getTreinadorLabel(Treinador treinador) {
        JLabel label = new JLabel(treinador.getNome());
        label.setBounds(460, 210, 350, 40);
        label.setFont(PokeHubAssets.getFont(0,34f));
        label.setForeground(new Color(0, 0, 0));
        return label;
    }

    public static JButton getCapturarButton(JFrame tela,
                                            PokemonController controller,
                                            Treinador treinador,
                                            Pokemon pokemon) {
        JButton button = new JButton("CAPTURAR");
        button.setBounds(450, 340, 150, 40);
        button.setFont(PokeHubAssets.getFont(1,24f));
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(0, 0, 0));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> abrirCapturar(tela, controller, treinador, pokemon));
        return button;
    }

    public static JButton getFugirButton(JFrame tela) {
        JButton button = new JButton("FUGIR");
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

    private static void abrirCapturar(JFrame tela,
                                      PokemonController controller,
                                      Treinador treinador,
                                      Pokemon pokemon) {
        BatalhaAudio.pararMusica();
        tela.setVisible(false);
        new UINomearPokemon(controller, treinador, pokemon);
    }

    private static void fugir(JFrame tela) {
        BatalhaAudio.pararMusica();
        MenuAudio.ligarMusica();
        tela.setVisible(false);
    }

}
