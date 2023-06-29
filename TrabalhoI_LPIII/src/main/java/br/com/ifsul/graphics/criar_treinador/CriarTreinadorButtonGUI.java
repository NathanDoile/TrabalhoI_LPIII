package br.com.ifsul.graphics.criar_treinador;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

import static br.com.ifsul.graphics.menu.AudioGUI.ligarMusica;
import static java.awt.Font.BOLD;

@Component
public abstract class CriarTreinadorButtonGUI {

    public static JButton getOkButton() {
        JButton button = new JButton("OK");
        button.setBounds(650, 15, 120, 20);
        button.setFont(new Font("Calibri", BOLD, 12));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.addActionListener(e -> ligarMusica());
        return button;
    }

}
