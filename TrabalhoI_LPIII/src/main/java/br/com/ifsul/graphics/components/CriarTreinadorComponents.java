package br.com.ifsul.graphics.components;

import br.com.ifsul.graphics.UICriarTreinador;
import br.com.ifsul.graphics.assets.CriarTreinadorAssets;
import br.com.ifsul.graphics.assets.PokeHubAssets;
import br.com.ifsul.service.CriarTreinadorService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static br.com.ifsul.graphics.audio.CriarTreinadorAudio.ligarMusica;
import static br.com.ifsul.graphics.audio.CriarTreinadorAudio.pararMusica;

public abstract class CriarTreinadorComponents {

    public static JButton ligarMusicaButton() {
        JButton button = new JButton("Ligar Musica");
        button.setBounds(650, 15, 120, 20);
        button.setFont(PokeHubAssets.getFont(1,12f));
        button.setBackground(new Color(64, 136, 128));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> ligarMusica());
        return button;
    }
    public static JButton pararMusicaButton() {
        JButton button = new JButton("Parar Musica");
        button.setBounds(650, 40, 120, 20);
        button.setFont(PokeHubAssets.getFont(1,12f));
        button.setBackground(new Color(64, 136, 128));
        button.setForeground(new Color(255, 255, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> pararMusica());
        return button;
    }



    public static JButton proximaConversaButton(JLabel conversa,
                                                List<String> conversaList,
                                                CriarTreinadorService service,
                                                JFrame conversaUI,
                                                JFrame telaInicialUI
                                                ) {
        JButton button = new JButton("       ");
        button.setBounds(700, 375, 50, 50);
        button.setFont(PokeHubAssets.getFont(1,12f));
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(255, 255, 255));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setIcon(CriarTreinadorAssets.getSetinhaDireita(button));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> proximaConversa(conversa, conversaList, service, conversaUI, telaInicialUI));
        return button;
    }

    public static void proximaConversa(JLabel conversa,
                                       List<String> conversaList,
                                       CriarTreinadorService service,
                                       JFrame conversaUI,
                                       JFrame telaInicialUI) {
        for(int i=0;i<conversaList.size();i++) {

            if(conversaList.get(i).equals(conversa.getText())) {
                if(i+1 == conversaList.size()) {
                    iniciarNomearTreinador(service, conversaUI, telaInicialUI);
                }
                else {
                    conversa.setText(conversaList.get(i+1));
                    break;
                }
            }
        }

    }

    private static void iniciarNomearTreinador(CriarTreinadorService service,
                                               JFrame conversa,
                                               JFrame telaInicial) {
        new UICriarTreinador(service, telaInicial);
        conversa.setVisible(false);
    }

}
