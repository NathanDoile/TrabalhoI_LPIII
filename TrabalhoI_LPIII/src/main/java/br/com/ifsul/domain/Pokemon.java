package br.com.ifsul.domain;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.util.List;

import br.com.ifsul.domain.enums.NomePokemon;
import jakarta.persistence.*;
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

	@Enumerated(STRING)
	private NomePokemon nome;
	
	private String apelido;
	
	private int level;
	
	private int experiencia;

	private LocalDate dataCapturado;

	private int experienciaParaSubirLevel;

	@ManyToOne
	@JoinColumn(name = "treinador_id")
	private Treinador treinador;

	public void adicionarExperiencia(int experiencia){
		this.experiencia += experiencia;
	}

	public void subirLevel(){
		this.level++;
		this.experienciaParaSubirLevel += 10;
	}

	public void evoluir(NomePokemon novoPokemon){
		this.nome = novoPokemon;
	}
}
