package br.com.ifsul.service.treinador;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.domain.enums.NomePokemon;
import br.com.ifsul.repository.PokemonRepository;
import br.com.ifsul.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarTreinadoresPorPokemonService {

    @Autowired
    private TreinadorRepository treinadorRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Treinador> buscar(NomePokemon nome){

        List<Pokemon> pokemons = pokemonRepository.findByNome(nome);

        List<Treinador> treinadores = new ArrayList<>();

        for(Pokemon pokemon : pokemons){
            treinadores.add(treinadorRepository.findByPokemons(pokemon));
        }

        return treinadores;
    }
}
