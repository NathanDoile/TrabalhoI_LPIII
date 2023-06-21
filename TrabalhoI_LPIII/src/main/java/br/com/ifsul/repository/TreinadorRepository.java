package br.com.ifsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifsul.domain.Treinador;

public interface TreinadorRepository extends JpaRepository<Treinador, Long> {

}
