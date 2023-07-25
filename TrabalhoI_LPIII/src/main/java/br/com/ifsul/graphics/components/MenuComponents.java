package br.com.ifsul.graphics.components;

import br.com.ifsul.controller.PokemonController;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.domain.enums.Sexo;
import br.com.ifsul.graphics.UICapturarPokemon;
import br.com.ifsul.graphics.UIListarPokemon;
import br.com.ifsul.graphics.assets.MenuAssets;
import br.com.ifsul.graphics.assets.PokeHubAssets;
import br.com.ifsul.graphics.audio.MenuAudio;
import br.com.ifsul.graphics.audio.TelaInicialAudio;

import javax.swing.*;
import java.awt.*;

import static br.com.ifsul.graphics.audio.MenuAudio.ligarMusica;
import static br.com.ifsul.graphics.audio.MenuAudio.pararMusica;

public abstract class MenuComponents {

    public static JLabel getNameLabel(String name) {
        JLabel label = new JLabel(name);
        label.setBounds(550, 25, 250, 100);
        label.setFont(PokeHubAssets.getFont(0,42f));
        label.setForeground(new Color(0, 0, 0));
        return label;
    }

    public static JLabel getSprite(Sexo sexo) {
        JLabel sprite = new JLabel();
        sprite.setBounds(375, 70,400,400);
        Image spriteImg = MenuAssets.getSprite(sexo).getScaledInstance(sprite.getWidth(), sprite.getHeight(), Image.SCALE_SMOOTH);;
        sprite.setIcon(new ImageIcon(spriteImg));
        return sprite;
    }

    public static JButton getVerPokemonsButton(Treinador treinador, PokemonController controller) {
        JButton button = new JButton("Visualizar Pokemon");
        button.setBounds(25, 50, 180, 40);
        button.setFont(PokeHubAssets.getFont(1,16f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> abrirVerPokemon(treinador, controller));
        return button;
    }

    public static JButton getCapturarPokemonButton(Treinador treinador, PokemonController controller) {
        JButton button = new JButton("Capturar Pokemon");
        button.setBounds(25, 100, 180, 40);
        button.setFont(PokeHubAssets.getFont(1,16f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> abrirCapturarPokemon(treinador,controller));
        return button;
    }

    public static JButton getBatalhaPokemonButton() {
        JButton button = new JButton("Batalha Pokemon");
        button.setBounds(25, 150, 180, 40);
        button.setFont(PokeHubAssets.getFont(1,16f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    public static JButton getSairButton(JFrame telaInicial, JFrame telaAtual) {
        JButton button = new JButton("Sair do Menu");
        button.setBounds(25, 200, 180, 40);
        button.setFont(PokeHubAssets.getFont(1,16f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> sair(telaInicial, telaAtual));
        return button;
    }

    public static JButton getLigarMusica() {
        JButton button = new JButton("Ligar Musica");
        button.setBounds(25, 400, 120, 20);
        button.setFont(PokeHubAssets.getFont(1,12f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> ligarMusica());
        return button;
    }
    public static JButton getPararMusica() {
        JButton button = new JButton("Parar Musica");
        button.setBounds(25, 425, 120, 20);
        button.setFont(PokeHubAssets.getFont(1,12f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> pararMusica());
        return button;
    }

    private static void sair(JFrame telaInicial, JFrame telaAtual) {
        MenuAudio.pararMusica();
        TelaInicialAudio.ligarMusica();
        telaInicial.setVisible(true);
        telaAtual.setVisible(false);
    }

    private static void abrirCapturarPokemon(Treinador treinador, PokemonController controller) {
        MenuAudio.pararMusica();
        new UICapturarPokemon(treinador, controller);
    }


    private static void abrirVerPokemon(Treinador treinador, PokemonController controller) {
        new UIListarPokemon(controller, treinador);
    }
}
