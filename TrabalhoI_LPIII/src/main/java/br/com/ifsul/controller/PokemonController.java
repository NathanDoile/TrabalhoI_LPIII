package br.com.ifsul.controller;

import br.com.ifsul.service.pokemon.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonController {

    @Autowired
    public CapturarPokemonService capturarPokemonService;

    @Autowired
    public BuscarPokemonService buscarPokemonService;

    @Autowired
    public BuscarPokemonsTreinadorService buscarPokemonsTreinadorService;

    @Autowired
    public EvoluirPokemonService evoluirPokemonService;

    @Autowired
    public ListarPokemonService listarPokemonService;

}
