package br.com.ifsul.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.repository.PokemonRepository;
import br.com.ifsul.repository.TreinadorRepository;

@Service
public class BatalharPokemonsService {
	
	@Autowired
	private TreinadorRepository treinadorRepository;
	
	@Autowired
	private PokemonRepository pokemonRepository;

	public void batalhar(Treinador treinador) {
		
		Random random = new Random();
		
		List<Treinador> treinadores = treinadorRepository.findAllByIdNotIn(List.of(treinador.getId()));
		
		Treinador adversario = treinadores.get(random.nextInt(treinadores.size()));
		
		List<Pokemon> pokemonsTreinador = pokemonRepository.findAllByTreinador(treinador);
		
		List<Pokemon> pokemonsAdversario = pokemonRepository.findAllByTreinador(adversario);
		
		Pokemon pokemonTreinador = pokemonsTreinador.get(random.nextInt(pokemonsTreinador.size()));
		
		Pokemon pokemonAdversario = pokemonsAdversario.get(random.nextInt(pokemonsAdversario.size()));
		
		
	}
}
