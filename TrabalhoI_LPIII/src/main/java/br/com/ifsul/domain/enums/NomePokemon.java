package br.com.ifsul.domain.enums;

public enum NomePokemon {
	
	SQUIRTLE(5,0, 120, "WARTORTLE"), WARTORTLE(16,160, 360, "BLASTOISE"), BLASTOISE(36,360, 0, "SEM_EVOLUÇÃO"),
	CHARMANDER(5,0, 120, "CHARMELEON"), CHARMELEON(16,160, 360, "CHARIZARD"), CHARIZARD(36,360, 0, "SEM_EVOLUÇÃO"),
	BULBASAUR(5,0, 120, "IVYSAUR"), IVYSAUR(16,160, 320, "VENUSAUR"), VENUSAUR(32,320, 0, "SEM_EVOLUÇÃO");

	private int nivel;

	private int exp;

	private int expParaEvolucao;

	private String pokemonEvolucao;

	private NomePokemon(int nivel, int exp, int expParaEvolucao, String pokemonEvolucao) {
		this.nivel = nivel;
		this.exp = exp;
		this.expParaEvolucao = expParaEvolucao;
		this.pokemonEvolucao = pokemonEvolucao;
	}

	public int getNivel() {
		return nivel;
	}

	public int getExp() {
		return exp;
	}

	public int getExpParaEvolucao() {
		return expParaEvolucao;
	}

	public String getPokemonEvolucao() {
		return pokemonEvolucao;
	}
}
