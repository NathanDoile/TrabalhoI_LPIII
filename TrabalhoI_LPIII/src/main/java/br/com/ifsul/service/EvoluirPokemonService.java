package br.com.ifsul.service;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.enums.NomePokemon;
import br.com.ifsul.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.ifsul.domain.enums.NomePokemon.valueOf;

@Service
public class EvoluirPokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Transactional
    public void evoluir(Pokemon pokemon, int xp){

        pokemon.adicionarExperiencia(xp);

        if(pokemon.getExperiencia() >= pokemon.getExperienciaParaSubirLevel()){
            pokemon.subirLevel();
        }

        if(pokemon.getExperiencia() >= pokemon.getNome().getExpParaEvolucao() && pokemon.getNome().getExpParaEvolucao() != 0){

            NomePokemon pokemonEvolucao =   valueOf(pokemon.getNome().getPokemonEvolucao());

            pokemon.evoluir(pokemonEvolucao);
        }

        pokemonRepository.save(pokemon);
    }
}
