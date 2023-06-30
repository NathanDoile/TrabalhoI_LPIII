package br.com.ifsul.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.annotation.PostConstruct;
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
	public void batalhar(Treinador treinador) {

		Random random = new Random();
		
		Treinador adversario = selecionaTreinador(treinador, random);

		Pokemon pokemonTreinador = selecionaPokemon(treinador, random);

		Pokemon pokemonAdversario = selecionaPokemon(adversario, random);

		List<Pokemon> rodaDaSorte = new ArrayList<>();

		for(int i = 0; i < pokemonTreinador.getNome().getNivel(); i++){
			rodaDaSorte.add(pokemonTreinador);
		}

		for(int i = 0; i < pokemonAdversario.getNome().getNivel(); i++){
			rodaDaSorte.add(pokemonAdversario);
		}

		Pokemon pokemonVitorioso = rodaDaSorte.get(random.nextInt(rodaDaSorte.size()));

		Treinador treinadorVitorioso = treinadorRepository.findByPokemons(pokemonVitorioso);

		evoluirPokemonService.evoluir(pokemonVitorioso, 5);
	}

	private Pokemon selecionaPokemon(Treinador treinador, Random random){

		List<Pokemon> pokemons = pokemonRepository.findAllByTreinador(treinador);

		Pokemon pokemon = pokemons.get(random.nextInt(pokemons.size()));

		return pokemon;
	}

	private Treinador selecionaTreinador(Treinador treinador, Random random){

		List<Treinador> treinadores = treinadorRepository.findAllByIdNotIn(List.of(treinador.getId()));

		Treinador adversario = treinadores.get(random.nextInt(treinadores.size()));

		return adversario;
	}
}
