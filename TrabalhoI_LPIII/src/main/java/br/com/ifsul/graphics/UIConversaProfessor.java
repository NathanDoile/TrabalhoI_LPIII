package br.com.ifsul.graphics;

import br.com.ifsul.controller.TreinadorController;
import br.com.ifsul.graphics.assets.PokeHubAssets;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static br.com.ifsul.graphics.assets.CriarTreinadorAssets.getConversaWallpaper;
import static br.com.ifsul.graphics.assets.PokeHubAssets.getIcon;
import static br.com.ifsul.graphics.audio.CriarTreinadorAudio.iniciarMusica;
import static br.com.ifsul.graphics.components.CriarTreinadorComponents.*;

public class UIConversaProfessor extends JFrame{

	private List<String> conversaList = new ArrayList<>(List.of(
			"Ola, eu sou o Professor Mauricio! Clique na seta ao lado para continuar.",
			"Seja bem-vindo ao PokeHub, agora voce ira criar um novo treinador.",
			"A seguir, escolha o nome e sexo do treinador."
	));

	public UIConversaProfessor(TreinadorController controller, JFrame telaInicialUI) {
		BufferedImage icon = getIcon();
		iniciarMusica();

		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(250, 100, 800, 500);
		this.setResizable(false);
		this.setIconImage(icon);
		this.setTitle("Criar Treinador");

		Image wallpaper = getConversaWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);;
		this.setContentPane(new JLabel(new ImageIcon(wallpaper)));

		JLabel conversa = new JLabel();
		conversa.setText(conversaList.get(0));
		conversa.setBounds(50, 355, 700, 50);
		conversa.setFont(PokeHubAssets.getFont(0,28f));
		conversa.setBackground(new Color(255, 255, 255));
		conversa.setForeground(new Color(0, 0, 0));

		this.add(conversa);
		this.add(pararMusicaButton());
		this.add(ligarMusicaButton());
		this.add(proximaConversaButton(conversa, conversaList, controller, this, telaInicialUI));
		this.setVisible(true);
	   }
}
