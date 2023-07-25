package br.com.ifsul.service;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CapturarPokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public void capturar(String apelido, Treinador treinador, Pokemon pokemon) {
        pokemon.setTreinador(treinador);
        pokemon.setApelido(apelido);
        pokemon.setDataCapturado(LocalDate.now());
        pokemonRepository.save(pokemon);
    }

}
