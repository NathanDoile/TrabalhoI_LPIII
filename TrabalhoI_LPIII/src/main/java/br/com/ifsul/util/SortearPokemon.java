package br.com.ifsul.util;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.enums.NomePokemon;

import java.util.Random;

public abstract class SortearPokemon {

    public static Pokemon sortearPokemon() {
        Random random = new Random();

        int pokemonsExistentes = NomePokemon.values().length;

        NomePokemon nome = NomePokemon.values()[random.nextInt(pokemonsExistentes)];

        return Pokemon
                .builder()
                .nome(nome)
                .level(nome.getNivel())
                .experiencia(nome.getExp())
                .build();
    }

}
