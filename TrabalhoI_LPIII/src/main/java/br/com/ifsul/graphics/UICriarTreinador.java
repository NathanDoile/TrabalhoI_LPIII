package br.com.ifsul.graphics;

import static br.com.ifsul.domain.enums.Sexo.MASCULINO;
import static br.com.ifsul.graphics.ImageGUI.getIcon;
import static java.awt.Font.PLAIN;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import br.com.ifsul.domain.enums.Sexo;
import br.com.ifsul.graphics.ImageGUI;
import br.com.ifsul.service.CriarTreinadorService;

public class UICriarTreinador extends JFrame{

	private Sexo sexo = MASCULINO;

	public UICriarTreinador(CriarTreinadorService service) {	

	       BufferedImage icon = getIcon();

	       this.setLayout(null);
	       this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	       this.setBounds(500, 100, 800, 500);
	       this.setResizable(false);
	       this.setIconImage(icon);
	       this.setTitle("Criar Treinador");

	       Image wallpaper = ImageGUI.getTreinadorWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);;
	       this.setContentPane(new JLabel(new ImageIcon(wallpaper)));

		JTextField nameField = new JTextField();
		nameField.setBounds(325, 135, 200, 40);
		nameField.setFont(ImageGUI.getFont(0,24f));

		JButton OKbutton = new JButton("OK");
		OKbutton.setBounds(627, 395,93, 30);
		OKbutton.setFont(ImageGUI.getFont(1,26f));
		OKbutton.setBackground(new Color(222, 214, 89));
		OKbutton.setForeground(new Color(255, 255, 255));
		OKbutton.addActionListener(e -> criarTreinador(service,nameField));

		JButton backButton = new JButton("VOLTAR");
		backButton.setBounds(627, 323,93, 30);
		backButton.setFont(ImageGUI.getFont(1,20f));
		backButton.setBackground(new Color(222, 214, 89));
		backButton.setForeground(new Color(255, 255, 255));
		backButton.addActionListener(e -> voltar());

		JLabel sprite = new JLabel();
		sprite.setBounds(150, 75,55,73);
		Image spriteImg = ImageGUI.getSprite1(this.sexo).getScaledInstance(sprite.getWidth(), sprite.getHeight(), Image.SCALE_SMOOTH);;
		sprite.setIcon(new ImageIcon(spriteImg));

		String[] sexos = {"MASCULINO","FEMININO"};
		JComboBox sexoOption = new JComboBox(sexos);
		sexoOption.setBounds(125, 150,125, 20);
		sexoOption.setFont(ImageGUI.getFont(1,18f));
		sexoOption.addActionListener(e -> selectSexo(sexoOption.getSelectedItem().toString(), sprite));

		this.setVisible(true);
		this.add(nameField);
		this.add(sexoOption);
		this.add(OKbutton);
		this.add(backButton);
		this.add(sprite);
	   }

	   private void criarTreinador(CriarTreinadorService service, JTextField nameField) {

			service.criarTreinador(nameField.getText(), this.sexo);
			nameField.setText("");
			this.setVisible(false);
	   }

	   private void selectSexo(String sexo, JLabel sprite) {
		this.sexo = Sexo.valueOf(sexo);
		   Image spriteImg = ImageGUI.getSprite1(this.sexo).getScaledInstance(sprite.getWidth(), sprite.getHeight(), Image.SCALE_SMOOTH);;
		   sprite.setIcon(new ImageIcon(spriteImg));
	   }

	   private void voltar() {
		this.setVisible(false);
	   }
}
