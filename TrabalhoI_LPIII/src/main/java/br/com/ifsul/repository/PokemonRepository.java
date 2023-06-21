package br.com.ifsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifsul.domain.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
