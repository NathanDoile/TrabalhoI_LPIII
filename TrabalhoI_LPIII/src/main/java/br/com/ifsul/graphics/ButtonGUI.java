package br.com.ifsul.graphics;

import javax.swing.*;

import br.com.ifsul.service.CriarTreinadorService;
import br.com.ifsul.service.ListarTreinadoresService;

import java.awt.*;

import static br.com.ifsul.graphics.AudioGUI.*;

public abstract class ButtonGUI {

    public static JButton getCriarTreinadorButton(CriarTreinadorService service) {
        JButton button = new JButton("Criar Treinador");
        button.setBounds(25, 50, 180, 40);
        button.setFont(ImageGUI.getFont(1,16f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.addActionListener(e -> new UICriarTreinador(service));
        return button;
    }

    public static JButton getListarTreinadoresButton(ListarTreinadoresService service) {
        JButton button = new JButton("Listar Treinadores");
        button.setBounds(25, 100, 180, 40);
        button.setFont(ImageGUI.getFont(1,16f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.addActionListener(e -> new UIListarTreinadores(service));
        return button;
    }

    public static JButton getCapturarPokemonButton() {
        JButton button = new JButton("Capturar Pokemon");
        button.setBounds(25, 150, 180, 40);
        button.setFont(ImageGUI.getFont(1,16f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        button.addActionListener(e -> new UICapturar());
        return button;
    }

    public static JButton getBatalhaPokemonButton() {
        JButton button = new JButton("Batalha Pokemon");
        button.setBounds(25, 200, 180, 40);
        button.setFont(ImageGUI.getFont(1,16f));
        button.setBackground(new Color(84, 145, 212));
        button.setForeground(new Color(255, 255, 255));
        return button;
    }

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
