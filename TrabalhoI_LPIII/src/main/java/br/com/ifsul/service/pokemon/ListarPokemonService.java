package br.com.ifsul.service.pokemon;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarPokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> porTreinador(Long id) {
        return pokemonRepository.findByTreinadorId(id);
    }

}
