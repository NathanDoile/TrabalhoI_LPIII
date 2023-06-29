package br.com.ifsul.graphics.criar_treinador;

import br.com.ifsul.domain.enums.Sexo;
import br.com.ifsul.service.CriarTreinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static br.com.ifsul.domain.enums.Sexo.MASCULINO;
import static br.com.ifsul.graphics.criar_treinador.CriarTreinadorImageGUI.getIcon;
import static br.com.ifsul.graphics.criar_treinador.CriarTreinadorImageGUI.getWallpaper;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;

public class CriarTreinadorScreen {

    @Autowired
    private CriarTreinadorService criarTreinadorService;
    private String nome = null;
    private Sexo sexo = MASCULINO;

   public void inicializar() {

       BufferedImage icon = getIcon();

       JFrame janela = new JFrame();
       janela.setLayout(null);
       janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       janela.setBounds(500, 100, 800, 500);
       janela.setResizable(false);
       janela.setIconImage(icon);
       janela.setTitle("PokeHub");

       Image wallpaper = getWallpaper().getScaledInstance(janela.getWidth(), janela.getHeight(), Image.SCALE_SMOOTH);;
       janela.setContentPane(new JLabel(new ImageIcon(wallpaper)));

       JTextField nameField = new JTextField();
       nameField.setBounds(325, 135, 200, 40);
       nameField.setFont(new Font("Calibri", PLAIN, 18));

       JButton OKbutton = new JButton("OK");
       OKbutton.setBounds(620, 385, 110, 45);
       OKbutton.setFont(new Font("Calibri", BOLD, 28));
       OKbutton.setBackground(new Color(222, 214, 89));
       OKbutton.setForeground(new Color(255, 255, 255));
       OKbutton.addActionListener(e -> criarTreinador(nameField.getText()));

       janela.setVisible(true);
       janela.add(nameField);
       janela.add(OKbutton);
   }
   private void criarTreinador(String nome) {
       this.nome = nome;
       criarTreinadorService.criarTreinador(nome, this.sexo);

       this.sexo = MASCULINO;
       this.nome = null;
   }
}
