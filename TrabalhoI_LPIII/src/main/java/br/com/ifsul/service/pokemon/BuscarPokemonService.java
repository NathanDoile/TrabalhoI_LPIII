package br.com.ifsul.service.pokemon;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarPokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public Pokemon porIdETreinador(long pokemonId, Treinador treinador) {

        return pokemonRepository.findByIdAndTreinador(pokemonId, treinador);
    }
}
