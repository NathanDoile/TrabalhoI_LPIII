package br.com.ifsul;

import br.com.ifsul.controller.PokemonController;
import br.com.ifsul.controller.TreinadorController;
import br.com.ifsul.graphics.UITelaInicial;
import br.com.ifsul.service.pokemon.CapturarPokemonService;
import br.com.ifsul.service.pokemon.CriarPokemonService;
import br.com.ifsul.service.treinador.BuscarTreinadorService;
import br.com.ifsul.service.treinador.CriarTreinadorService;
import br.com.ifsul.service.treinador.ListarTreinadoresService;
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

	@Autowired
	private TreinadorController treinadorController;

	@Autowired
	private PokemonController pokemonController;

	public static void main(String[] args) {
		SpringApplicationBuilder sab = new SpringApplicationBuilder(TrabalhoILpiiiApplication.class);
		sab.headless(false);
		ConfigurableApplicationContext cac = sab.run(args);
		TrabalhoILpiiiApplication ms = cac.getBean(TrabalhoILpiiiApplication.class);

		new UITelaInicial(
				ms.treinadorController,
				ms.pokemonController);
		/*SpringApplication.run(TrabalhoILpiiiApplication.class, args);*/

	}

}
