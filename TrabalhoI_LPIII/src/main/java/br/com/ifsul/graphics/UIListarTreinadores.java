package br.com.ifsul.graphics;

import br.com.ifsul.domain.Treinador;
import br.com.ifsul.graphics.assets.PokeHubAssets;
import br.com.ifsul.graphics.audio.TelaInicialAudio;
import br.com.ifsul.service.BuscarTreinadorService;
import br.com.ifsul.service.ListarTreinadoresService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

import static br.com.ifsul.graphics.assets.PokeHubAssets.getIcon;

public class UIListarTreinadores extends JFrame{

	private DefaultListModel<String> dadosLista = new DefaultListModel<>();
	private JList<String> lista = new JList<>(dadosLista);

	public UIListarTreinadores(ListarTreinadoresService service, BuscarTreinadorService buscarTreinadorService, JFrame telaInicial) {

	       BufferedImage icon = getIcon();

	       this.setLayout(null);
	       this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	       this.setBounds(500, 100, 800, 500);
	       this.setResizable(false);
	       this.setIconImage(icon);
	       this.setTitle("Listar Treinadores");

	       Image wallpaper = PokeHubAssets.getListarTreinadoresWallpaper().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);;
	       this.setContentPane(new JLabel(new ImageIcon(wallpaper)));

		String[] sexos = {"NENHUM","PIKACHU"};
		JComboBox sexoOption = new JComboBox(sexos);
		sexoOption.setBounds(75, 20,125, 18);
		sexoOption.setFont(PokeHubAssets.getFont(1,16f));

		lista.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent evt) {
				onClickList(evt, telaInicial,buscarTreinadorService);
			}
		});

		listarTreinadores(service);
		JScrollPane painel = new JScrollPane(lista);
		painel.setBounds(0,40,this.getWidth(),this.getHeight());
		painel.setFont(PokeHubAssets.getFont(1,28f));


		this.add(painel);
		this.add(sexoOption);
		this.setVisible(true);
	   }

	   private void listarTreinadores(ListarTreinadoresService service) {
		List<Treinador> treinadorList = service.listarTodos();

		for(int i=0;i<treinadorList.size();i++) {

			StringBuilder info = new StringBuilder();
			info.append("<html>");
			info.append(String.format("<p>%d. %s - %s</p>", treinadorList.get(i).getId(), treinadorList.get(i).getNome(), treinadorList.get(i).getSexo().toString()));
			info.append("</html>");

			dadosLista.addElement(info.toString());
		}
	   }

	   private void onClickList(ListSelectionEvent evt, JFrame telaInicial, BuscarTreinadorService buscarTreinadorService) {
		   String text = (String) lista.getSelectedValue();
		   int index = text.indexOf(".");
		   String id = text.substring(9, index);

		   this.setVisible(false);
		   telaInicial.setVisible(false);
		   TelaInicialAudio.pararMusica();

		   new UIMenu(Long.valueOf(id), buscarTreinadorService, telaInicial);
	   }

}
