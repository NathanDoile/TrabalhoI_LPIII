package br.com.ifsul;

import br.com.ifsul.graphics.UITelaInicial;
import br.com.ifsul.service.*;
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

	@Autowired
	private CriarPokemonService criarPokemonService;

	@Autowired
	private CapturarPokemonService capturarPokemonService;

	public static void main(String[] args) {
		SpringApplicationBuilder sab = new SpringApplicationBuilder(TrabalhoILpiiiApplication.class);
		sab.headless(false);
		ConfigurableApplicationContext cac = sab.run(args);
		TrabalhoILpiiiApplication ms = cac.getBean(TrabalhoILpiiiApplication.class);

		new UITelaInicial(
				ms.criarTreinadorService,
				ms.listarTreinadoresService,
				ms.buscarTreinadorService,
				ms.criarPokemonService,
				ms.capturarPokemonService);
	}

}
