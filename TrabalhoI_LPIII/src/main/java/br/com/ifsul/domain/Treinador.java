package br.com.ifsul.domain;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.List;

import br.com.ifsul.domain.enums.Sexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Treinador {

	@Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
	
	private String nome;

	@Enumerated(STRING)
	private Sexo sexo;

	@OneToMany(mappedBy = "treinador", cascade = PERSIST)
	private List<Pokemon> pokemons;

	@Override
	public String toString() {
		return "Treinador{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", sexo=" + sexo +
				'}';
	}
}
