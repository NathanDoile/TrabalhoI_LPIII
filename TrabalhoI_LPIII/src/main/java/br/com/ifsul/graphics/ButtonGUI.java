package br.com.ifsul.graphics;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static br.com.ifsul.graphics.AudioGUI.*;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;

public abstract class ButtonGUI {

    public static JButton getCriarTreinadorButton() {
        JButton button = new JButton("Criar Treinador");
        button.setBounds(25, 50, 180, 40);
        button.setFont(new Font("Calibri", BOLD, 16));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        return button;
    }

    public static JButton getListarTreinadoresButton() {
        JButton button = new JButton("Listar Treinadores");
        button.setBounds(25, 100, 180, 40);
        button.setFont(new Font("Calibri", BOLD, 16));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        return button;
    }

    public static JButton getCapturarPokemonButton() {
        JButton button = new JButton("Capturar Pokemon");
        button.setBounds(25, 150, 180, 40);
        button.setFont(new Font("Calibri", BOLD, 16));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        return button;
    }

    public static JButton getBatalhaPokemonButton() {
        JButton button = new JButton("Batalha Pokemon");
        button.setBounds(25, 200, 180, 40);
        button.setFont(new Font("Calibri", BOLD, 16));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        return button;
    }

    public static JButton getLigarMusica() {
        JButton button = new JButton("Ligar Musica");
        button.setBounds(650, 15, 120, 20);
        button.setFont(new Font("Calibri", PLAIN, 12));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.addActionListener(e -> ligarMusica());
        return button;
    }
    public static JButton getPararMusica() {
        JButton button = new JButton("Parar Musica");
        button.setBounds(650, 40, 120, 20);
        button.setFont(new Font("Calibri", PLAIN, 12));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.addActionListener(e -> pararMusica());
        return button;
    }
}
