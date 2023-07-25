package br.com.ifsul;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.domain.enums.NomePokemon;
import br.com.ifsul.domain.enums.Sexo;
import br.com.ifsul.service.BatalharPokemonsService;
import br.com.ifsul.service.pokemon.BuscarPokemonService;
import br.com.ifsul.service.pokemon.BuscarPokemonsTreinadorService;
import br.com.ifsul.service.pokemon.CapturarPokemonService;
import br.com.ifsul.service.pokemon.CriarPokemonService;
import br.com.ifsul.service.treinador.BuscarTreinadorService;
import br.com.ifsul.service.treinador.BuscarTreinadoresSemTreinadorService;
import br.com.ifsul.service.treinador.CriarTreinadorService;
import br.com.ifsul.service.treinador.ListarTreinadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static br.com.ifsul.domain.enums.Sexo.FEMININO;
import static br.com.ifsul.domain.enums.Sexo.MASCULINO;
import static java.util.Objects.isNull;

@Component
public class Menu {

    Scanner sc = new Scanner(System.in);

    @Autowired
    private BuscarTreinadorService buscarTreinadorService;

    @Autowired
    private CapturarPokemonService capturarPokemonService;

    @Autowired
    private CriarPokemonService criarPokemonService;

    @Autowired
    private CriarTreinadorService criarTreinadorService;

    @Autowired
    private ListarTreinadoresService listarTreinadoresService;

    @Autowired
    private BatalharPokemonsService batalharPokemonsService;

    @Autowired
    private BuscarPokemonService buscarPokemonService;

    @Autowired
    private BuscarPokemonsTreinadorService buscarPokemonsTreinadorService;

    @Autowired
    private BuscarTreinadoresSemTreinadorService buscarTreinadoresSemTreinadorService;

    public void iniciarMenu() {
        boolean ativo = true;

        while(ativo) {
        	
            System.out.print(
                    """
                    ===========================
                             M E N U
                    ===========================
                    1. Criar Treinador
                    2. Listar Treinadores
                    3. Capturar Pokemon
                    4. Batalhar
                    8. Sair
                    """);

            switch (sc.nextInt()) {
                case 1 -> opcao1();
                case 2 -> opcao2();
                case 3 -> opcao3();
                case 4 -> opcao4();
                case 8 -> ativo = false;
                default -> System.out.println("Opção invalida! Tente novamente");
            }
        }
    }

    private void opcao1() {

        System.out.println("Qual o nome do seu treinador?");
        sc.nextLine();
        String nome = sc.nextLine();
        
        System.out.println("Qual o sexo do seu treinador?");
        System.out.println("1. Feminino");
        System.out.println("2. Masculino");

        boolean sexoLoop = true;
        
        Sexo sexo = null;
        
        while(sexoLoop) {
            switch (sc.nextInt()) {
                case 1 -> {
                    sexo = FEMININO;
                    sexoLoop = false;
                }
                case 2 -> {
                    sexo = MASCULINO;
                    sexoLoop = false;
                }
                default -> System.out.println("Opção inválida");
            }
        }
        
        Treinador treinador = criarTreinadorService.criarTreinador(nome, sexo);
        System.out.println("Parabéns, você criou: " + treinador);
    }

    private void opcao2() {
        System.out.println(listarTreinadoresService.listarTodos());
    }

    private void opcao3() {
        
        Pokemon pokemon = sortearPokemon();

        System.out.println("Digite o ID do Treinador que você deseja usar:");
        int treinadorId = sc.nextInt();
        
        Treinador treinador = buscarTreinadorService.porId((long) treinadorId);

        System.out.printf("%s entra na mata em busca de Pokémons.\n", treinador.getNome());
        System.out.printf("Um %s selvagem apareceu!! Deseja capturá-lo?\n", pokemon.getNome());
        System.out.println("1. Sim");
        System.out.println("2. Não");

        switch (sc.nextInt()) {
            case 1 -> {
                System.out.println("Parabéns! Você o capturou com sucesso!");
                System.out.printf("Escolha um apelido para seu %s\n", pokemon.getNome().toString());
                sc.nextLine();
                String apelido = sc.nextLine();
                capturarPokemonService.capturar(apelido, treinador, pokemon);
                System.out.printf("%s foi transportado para seu PC Pokemon!\n", apelido);
            }
            case 2 -> System.out.println("Você escapou!");
            default -> System.out.println("Opção invalida, o Pokemon fugiu...");
        }
    }

    private void opcao4(){

        Random random = new Random();

        System.out.println("Digite o ID do Treinador que você deseja usar:");
        int treinadorId = sc.nextInt();

        Treinador treinador = buscarTreinadorService.porId((long) treinadorId);

        System.out.println("Digite o ID do pokémon que você deseja usar:");
        int pokemonId = sc.nextInt();

        Pokemon pokemonTreinador = buscarPokemonService.porIdETreinador( pokemonId, treinador );

        if(isNull(pokemonTreinador)){
            System.out.println("Você não possui pokémon com esse ID.");
            return;
        }

        Treinador adversario = selecionaTreinador(treinador, random);

        Pokemon pokemonAdversario = selecionaPokemon(adversario, random);

        System.out.print(
                """
                ===========================
                      B A T A L H A
                ===========================
                """);

        System.out.println(treinador.getNome() + ": Vai, " + pokemonTreinador.getApelido() + "(" +
                pokemonTreinador.getNome() + ")!");

        System.out.println(adversario.getNome() + ": Eu escolho você, " + pokemonAdversario.getApelido() + "(" +
                pokemonAdversario.getNome() + ")!");

        Treinador vencedor =
                batalharPokemonsService.batalhar(pokemonTreinador, pokemonAdversario);

        if(Objects.equals(vencedor.getId(), treinador.getId())){
            System.out.print(
                    """
                   ===========================
                          V I T Ó R I A
                   ===========================
                      Seu pokémon recebeu 5
                      pontos de experiência!
                   ===========================
                          V I T Ó R I A
                   ===========================
                    """);
        }
        else{
            System.out.print(
                    """
                    ===========================
                          D E R R O T A
                    ===========================
                      Continue evoluindo seus
                             pokémons!
                    ===========================
                          D E R R O T A
                    ===========================
                    """);
        }
    }
    
    private Pokemon sortearPokemon() {
    	Random random = new Random();
        
        int pokemonsExistentes = NomePokemon.values().length;
        
        NomePokemon nome = NomePokemon.values()[random.nextInt(pokemonsExistentes)];
        
        return criarPokemonService.criarPokemon(nome);
    }

    private Pokemon selecionaPokemon(Treinador treinador, Random random){

        List<Pokemon> pokemons = buscarPokemonsTreinadorService.porTreinador(treinador);

        return pokemons.get(random.nextInt(pokemons.size()));
    }

    private Treinador selecionaTreinador(Treinador treinador, Random random){

        List<Treinador> treinadores = buscarTreinadoresSemTreinadorService.semTreinador(treinador);

        return treinadores.get(random.nextInt(treinadores.size()));
    }
}
