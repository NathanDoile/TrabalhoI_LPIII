package br.com.ifsul;

import br.com.ifsul.service.ListarTreinadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.ifsul.graphics.UIMenu;
import br.com.ifsul.service.CriarTreinadorService;

@SpringBootApplication
public class TrabalhoILpiiiApplication {
	
	@Autowired
	private CriarTreinadorService criarTreinadorService;
	@Autowired
	private ListarTreinadoresService listarTreinadoresService;
	
	public static void main(String[] args) {
		SpringApplicationBuilder sab = new SpringApplicationBuilder(TrabalhoILpiiiApplication.class);
		sab.headless(false); 
		ConfigurableApplicationContext cac = sab.run(args);
		TrabalhoILpiiiApplication ms = cac.getBean(TrabalhoILpiiiApplication.class);

		new UIMenu(
				ms.criarTreinadorService,
				ms.listarTreinadoresService);
	}
}
