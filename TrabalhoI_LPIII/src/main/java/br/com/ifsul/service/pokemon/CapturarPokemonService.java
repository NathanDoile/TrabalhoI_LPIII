package br.com.ifsul.service.pokemon;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class CapturarPokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Transactional
    public void capturar(String apelido, Treinador treinador, Pokemon pokemon) {

        pokemon.setTreinador(treinador);
        pokemon.setApelido(apelido);
        pokemon.setDataCapturado(LocalDate.now());
        pokemon.setExperienciaParaSubirLevel(pokemon.getNome().getExp() + 10);

        pokemonRepository.save(pokemon);
    }

}
