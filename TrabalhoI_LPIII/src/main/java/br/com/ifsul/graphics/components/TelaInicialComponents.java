package br.com.ifsul.graphics.components;

import br.com.ifsul.graphics.UIConversaProfessor;
import br.com.ifsul.graphics.UIListarTreinadores;
import br.com.ifsul.graphics.assets.PokeHubAssets;
import br.com.ifsul.service.BuscarTreinadorService;
import br.com.ifsul.service.CriarTreinadorService;
import br.com.ifsul.service.ListarTreinadoresService;

import javax.swing.*;
import java.awt.*;

import static br.com.ifsul.graphics.audio.TelaInicialAudio.ligarMusica;
import static br.com.ifsul.graphics.audio.TelaInicialAudio.pararMusica;

public abstract class TelaInicialComponents {

    public static JButton criarTreinadorButton(JFrame telaAtual, CriarTreinadorService service) {
        JButton button = new JButton("Criar Treinador");
        button.setBounds(75, 340, 280, 60);
        button.setFont(PokeHubAssets.getFont(1,24f));
        button.setBackground(new Color(0, 0, 0));
        button.setForeground(new Color(255, 255, 255));
        button.addActionListener(e -> iniciarTelaCriarTreinador(telaAtual, service));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    public static JButton carregarTreinadorButton(ListarTreinadoresService listarTreinadoresService,
                                                  BuscarTreinadorService buscarTreinadorService,
                                                  JFrame telaInicial) {
        JButton button = new JButton("Listar Treinadores");
        button.setBounds(425, 340, 280, 60);
        button.setFont(PokeHubAssets.getFont(1,24f));
        button.setBackground(new Color(0, 0, 0));
        button.setForeground(new Color(255, 255, 255));
        button.addActionListener(e -> new UIListarTreinadores(listarTreinadoresService, buscarTreinadorService, telaInicial));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    public static JButton ligarMusicaButton() {
        JButton button = new JButton("Ligar Musica");
        button.setBounds(650, 15, 120, 20);
        button.setFont(PokeHubAssets.getFont(1,12f));
        button.setBackground(new Color(52, 151, 47));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> ligarMusica());
        return button;
    }
    public static JButton pararMusicaButton() {
        JButton button = new JButton("Parar Musica");
        button.setBounds(650, 40, 120, 20);
        button.setFont(PokeHubAssets.getFont(1,12f));
        button.setBackground(new Color(52, 151, 47));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> pararMusica());
        return button;
    }

    public static JLabel creditosLabel() {
        JLabel label = new JLabel("Criado por: Nathan, Nicolle, Marcelle e Ruann");
        label.setBounds(200, 425, 500, 32);
        label.setFont(PokeHubAssets.getFont(0,28f));
        label.setForeground(new Color(255, 255, 255));
        return label;
    }

    private static void iniciarTelaCriarTreinador(JFrame telaAtual, CriarTreinadorService service) {
        pararMusica();
        telaAtual.setVisible(false);
        new UIConversaProfessor(service, telaAtual);
    }
}
