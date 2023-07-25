package br.com.ifsul.controller;

import br.com.ifsul.service.pokemon.CapturarPokemonService;
import br.com.ifsul.service.pokemon.CriarPokemonService;
import br.com.ifsul.service.treinador.BuscarTreinadorService;
import br.com.ifsul.service.treinador.CriarTreinadorService;
import br.com.ifsul.service.treinador.ListarTreinadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinadorController {

    @Autowired
    public CriarTreinadorService criarTreinadorService;
    @Autowired
    public ListarTreinadoresService listarTreinadoresService;
    @Autowired
    public BuscarTreinadorService buscarTreinadorService;
    @Autowired
    public CriarPokemonService criarPokemonService;
    @Autowired
    public CapturarPokemonService capturarPokemonService;

}
