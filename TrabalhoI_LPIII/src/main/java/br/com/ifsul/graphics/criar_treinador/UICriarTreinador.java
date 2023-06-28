package br.com.ifsul.graphics.criar_treinador;

import static br.com.ifsul.graphics.menu.AudioGUI.iniciarMusica;
import static br.com.ifsul.graphics.menu.ButtonGUI.getBatalhaPokemonButton;
import static br.com.ifsul.graphics.menu.ButtonGUI.getCapturarPokemonButton;
import static br.com.ifsul.graphics.menu.ButtonGUI.getCriarTreinadorButton;
import static br.com.ifsul.graphics.menu.ButtonGUI.getLigarMusica;
import static br.com.ifsul.graphics.menu.ButtonGUI.getListarTreinadoresButton;
import static br.com.ifsul.graphics.menu.ButtonGUI.getPararMusica;
import static br.com.ifsul.graphics.menu.ImageGUI.getIcon;
import static br.com.ifsul.graphics.menu.ImageGUI.getWallpaper;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.ifsul.graphics.menu.ImageGUI;
import br.com.ifsul.service.CriarTreinadorService;

public class UICriarTreinador extends JFrame{
	
	public UICriarTreinador(CriarTreinadorService service) {	

	       BufferedImage icon = getIcon();

	       this.setLayout(null);
	       this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	       this.setBounds(500, 100, 800, 500);
	       this.setResizable(false);
	       this.setIconImage(icon);
	       this.setTitle("PokeHub");

	       Image wallpaper = ImageGUI.getTreinadorWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);;
	       this.setContentPane(new JLabel(new ImageIcon(wallpaper)));

	       this.setVisible(true);
	   }

	
}
