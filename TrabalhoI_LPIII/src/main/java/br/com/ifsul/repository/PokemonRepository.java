package br.com.ifsul.repository;

import br.com.ifsul.domain.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifsul.domain.Pokemon;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findAllByTreinador(Treinador treinador);
}
