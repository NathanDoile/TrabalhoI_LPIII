package br.com.ifsul.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.ifsul.service.pokemon.EvoluirPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.repository.PokemonRepository;
import br.com.ifsul.repository.TreinadorRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BatalharPokemonsService {
	
	@Autowired
	private TreinadorRepository treinadorRepository;
	
	@Autowired
	private PokemonRepository pokemonRepository;

	@Autowired
	private EvoluirPokemonService evoluirPokemonService;

	@Transactional
	public Treinador batalhar(Pokemon pokemonTreinador, Pokemon pokemonAdversario) {

		Random random = new Random();

		List<Pokemon> rodaDaSorte = new ArrayList<>();

		for(int i = 0; i < pokemonTreinador.getNome().getNivel(); i++){
			rodaDaSorte.add(pokemonTreinador);
		}

		for(int i = 0; i < pokemonAdversario.getNome().getNivel(); i++){
			rodaDaSorte.add(pokemonAdversario);
		}

		Pokemon pokemonVitorioso = rodaDaSorte.get(random.nextInt(rodaDaSorte.size()));

		evoluirPokemonService.evoluir(pokemonVitorioso, 5);

		return treinadorRepository.findByPokemons(pokemonVitorioso);
	}
}
