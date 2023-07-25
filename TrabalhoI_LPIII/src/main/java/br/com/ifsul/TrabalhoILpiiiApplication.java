package br.com.ifsul;

import br.com.ifsul.graphics.UITelaInicial;
import br.com.ifsul.service.BuscarTreinadorService;
import br.com.ifsul.service.CriarTreinadorService;
import br.com.ifsul.service.ListarTreinadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TrabalhoILpiiiApplication {
	
	@Autowired
	private CriarTreinadorService criarTreinadorService;
	@Autowired
	private ListarTreinadoresService listarTreinadoresService;
	@Autowired
	private BuscarTreinadorService buscarTreinadorService;

	public static void main(String[] args) {
		SpringApplicationBuilder sab = new SpringApplicationBuilder(TrabalhoILpiiiApplication.class);
		sab.headless(false); 
		ConfigurableApplicationContext cac = sab.run(args);
		TrabalhoILpiiiApplication ms = cac.getBean(TrabalhoILpiiiApplication.class);

		new UITelaInicial(
				ms.criarTreinadorService,
				ms.listarTreinadoresService,
				ms.buscarTreinadorService);
		/*new UIMenu(
				ms.criarTreinadorService,
				ms.listarTreinadoresService);*/
	}
}
