package br.com.ifsul.service.pokemon;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.enums.NomePokemon;
import org.springframework.stereotype.Service;

@Service
public class CriarPokemonService {

    public Pokemon criarPokemon(NomePokemon nomePokemon) {
    	
        return Pokemon
                .builder()
                .nome(nomePokemon)
                .level(nomePokemon.getNivel())
                .experiencia(nomePokemon.getExp())
                .build();
    }

}
