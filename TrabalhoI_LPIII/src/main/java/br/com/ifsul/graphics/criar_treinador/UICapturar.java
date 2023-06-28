package br.com.ifsul.graphics.criar_treinador;

import static br.com.ifsul.graphics.menu.ImageGUI.getIcon;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.ifsul.graphics.menu.ImageGUI;
import br.com.ifsul.service.CriarTreinadorService;

public class UICapturar extends JFrame{
	
	public UICapturar() {	

	       BufferedImage icon = getIcon();

	       this.setLayout(null);
	       this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	       this.setBounds(500, 100, 800, 500);
	       this.setResizable(false);
	       this.setIconImage(icon);
	       this.setTitle("PokeHub");

	       Image wallpaper = ImageGUI.getCapturarWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);;
	       this.setContentPane(new JLabel(new ImageIcon(wallpaper)));

	       this.setVisible(true);
	   }
}
