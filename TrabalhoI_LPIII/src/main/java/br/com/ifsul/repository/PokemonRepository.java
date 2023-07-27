package br.com.ifsul.repository;

import br.com.ifsul.domain.Treinador;
import br.com.ifsul.domain.enums.NomePokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifsul.domain.Pokemon;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findAllByTreinador(Treinador treinador);

    Pokemon findByIdAndTreinador(long id, Treinador treinador);

    List<Pokemon> findByTreinadorId(Long id);

    Pokemon findFirstByTreinadorId(Long id);

    List<Pokemon> findByNome(NomePokemon nome);
}
