package br.com.ifsul.domain;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.List;

import br.com.ifsul.domain.enums.NomePokemon;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Pokemon {

	@Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
	
	private NomePokemon nome;
	
	private String apelido;
	
	private int level;
	
	private int experiencia;
}
