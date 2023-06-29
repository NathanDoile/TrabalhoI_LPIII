package br.com.ifsul.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import static br.com.ifsul.graphics.ImageGUI.getIcon;

public class UICapturar extends JFrame{
	
	public UICapturar() {
		BufferedImage icon = getIcon();
		BatalhaAudioGUI.iniciarMusicaBatalha();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				BatalhaAudioGUI.pararMusica();
			}
		});

		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(500, 100, 800, 500);
		this.setResizable(false);
		this.setIconImage(icon);
		this.setTitle("Capturar Pokémon");

		Image wallpaper = ImageGUI.getCapturarWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);;
		this.setContentPane(new JLabel(new ImageIcon(wallpaper)));

		this.add(getLigarMusica());
		this.add(getPararMusica());

		this.setVisible(true);
	   }

	public JButton getLigarMusica() {
		JButton button = new JButton("Ligar Musica");
		button.setBounds(675, 5, 100, 20);
		button.setFont(ImageGUI.getFont(1,12f));
		button.setBackground(new Color(84, 145, 212));
		button.setForeground(new Color(255, 255, 255));
		button.addActionListener(e -> BatalhaAudioGUI.ligarMusica());
		return button;
	}
	public JButton getPararMusica() {
		JButton button = new JButton("Parar Musica");
		button.setBounds(675, 28, 100, 20);
		button.setFont(ImageGUI.getFont(1,12f));
		button.setBackground(new Color(84, 145, 212));
		button.setForeground(new Color(255, 255, 255));
		button.addActionListener(e -> BatalhaAudioGUI.pararMusica());
		return button;
	}
}
