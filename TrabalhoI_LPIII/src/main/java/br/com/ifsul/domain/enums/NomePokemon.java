package br.com.ifsul.domain.enums;

public enum NomePokemon {
	SQUIRTLE(1,0), WARTOTLE(16,160), BLASTOISE(36,360),
	CHARMANDER(1,0), CHARMELEON(16,160), CHARIZARD(36,360),
	BULBASAUR(1,0), IVYSAUR(16,160), VENUSAUR(32,320);

	private int nivel;

	private int exp;

	private NomePokemon(int nivel, int exp) {
		this.nivel = nivel;
		this.exp = exp;
	}

	public int getNivel() {
		return nivel;
	}

	public int getExp() {
		return exp;
	}
}
