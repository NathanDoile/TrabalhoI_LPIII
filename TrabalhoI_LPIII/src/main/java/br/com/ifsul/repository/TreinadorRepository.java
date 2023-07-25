package br.com.ifsul.repository;

import br.com.ifsul.domain.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifsul.domain.Treinador;

public interface TreinadorRepository extends JpaRepository<Treinador, Long> {

    Treinador findByPokemons(Pokemon pokemon);
}
