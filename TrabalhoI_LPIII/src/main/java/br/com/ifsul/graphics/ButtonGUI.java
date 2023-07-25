package br.com.ifsul.graphics;

import javax.swing.*;
import java.awt.*;

import static br.com.ifsul.graphics.MenuAudioGUI.ligarMusica;
import static br.com.ifsul.graphics.MenuAudioGUI.pararMusica;

public abstract class ButtonGUI {


    public static JButton getLigarMusica() {
        JButton button = new JButton("Ligar Musica");
        button.setBounds(650, 15, 120, 20);
        button.setFont(ImageGUI.getFont(1,12f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.addActionListener(e -> ligarMusica());
        return button;
    }
    public static JButton getPararMusica() {
        JButton button = new JButton("Parar Musica");
        button.setBounds(650, 40, 120, 20);
        button.setFont(ImageGUI.getFont(1,12f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.addActionListener(e -> pararMusica());
        return button;
    }
}
