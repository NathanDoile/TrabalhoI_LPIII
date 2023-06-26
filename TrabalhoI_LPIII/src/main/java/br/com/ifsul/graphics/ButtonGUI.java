package br.com.ifsul.graphics;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public abstract class ButtonGUI {

    public static JButton getCriarTreinadorButton() {
        JButton button = new JButton("Criar Treinador");
        button.setBounds(25, 50, 180, 40);
        button.setFont(new Font("Calibri", Font.BOLD, 16));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        return button;
    }

    public static JButton getListarTreinadoresButton() {
        JButton button = new JButton("Listar Treinadores");
        button.setBounds(25, 100, 180, 40);
        button.setFont(new Font("Calibri", Font.BOLD, 16));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        return button;
    }

    public static JButton getCapturarPokemonButton() {
        JButton button = new JButton("Capturar Pokemon");
        button.setBounds(25, 150, 180, 40);
        button.setFont(new Font("Calibri", Font.BOLD, 16));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        return button;
    }

}
