package br.com.ifsul.service;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.enums.NomePokemon;
import br.com.ifsul.repository.PokemonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarPokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Transactional
    public Pokemon criarPokemon(NomePokemon nomePokemon) {
    	
        Pokemon pokemon = Pokemon
                .builder()
                .nome(nomePokemon)
                .level(nomePokemon.getNivel())
                .experiencia(nomePokemon.getExp())
                .build();
        
        pokemonRepository.save(pokemon);
        
        return pokemon;
    }

}
