package br.com.ifsul;

import br.com.ifsul.domain.Pokemon;
import br.com.ifsul.domain.Treinador;
import br.com.ifsul.domain.enums.NomePokemon;
import br.com.ifsul.domain.enums.Sexo;
import br.com.ifsul.repository.PokemonRepository;
import br.com.ifsul.repository.TreinadorRepository;
import br.com.ifsul.service.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

import static br.com.ifsul.domain.enums.Sexo.FEMININO;
import static br.com.ifsul.domain.enums.Sexo.MASCULINO;

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

    @PostConstruct
    public void iniciarMenu() {
        boolean ativo = true;

        while(ativo) {
            System.out.printf(
                    "===========================\n" +
                    "         M E N U\n" +
                    "===========================\n" +
                    "1. Criar Treinador\n" +
                    "2. Listar Treinadores\n" +
                    "3. Capturar Pokemon\n" +
                    "8. Sair\n" +
                            "");
            switch (sc.nextInt()) {
                case 1:
                    opcao1();
                    break;
                case 2:
                    opcao2();
                    break;
                case 3:
                    opcao3();
                    break;
                case 8:
                    ativo = false;
                    break;
                default:
                    System.out.println("Opção invalida! Tente novamente");
                    break;
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
                case 1:
                    sexo = FEMININO;
                    sexoLoop = false;
                    break;
                case 2:
                    sexo = MASCULINO;
                    sexoLoop = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        Treinador treinador = criarTreinadorService.criarTreinador(nome, sexo);
        System.out.println("Parabéns, você criou: "+treinador);
    }

    private void opcao2() {
        System.out.println(listarTreinadoresService.listarTodos());
    }

    private void opcao3() {
        Random random = new Random();
        NomePokemon nome = NomePokemon.values()[random.nextInt(9)];
        Pokemon pokemon = criarPokemonService.criarPokemon(nome);

        System.out.println("Digite o ID do Treinador que você deseja usar:");
        int treinadorId = sc.nextInt();
        Treinador treinador = buscarTreinadorService.porId(Long.valueOf(treinadorId));

        System.out.printf("%s entra na mata em busca de Pokemon.\n", treinador.getNome().toString());
        System.out.printf("Um %s selvagem apareceu!! Deseja capturá-lo?\n", pokemon.getNome());
        System.out.println("1. Sim");
        System.out.println("2. Não");
        switch (sc.nextInt()) {
            case 1:
                System.out.println("Parabéns! Você o capturou com sucesso!");
                System.out.printf("Escolha um apelido para seu %s\n", pokemon.getNome().toString());
                sc.nextLine();
                String apelido = sc.nextLine();
                capturarPokemonService.capturar(apelido, treinador, pokemon);
                System.out.printf("%s foi transportado para seu PC Pokemon!\n", apelido);
                break;
            case 2:
                System.out.println("Você escapou!");
                break;
            default:
                System.out.println("Opção invalida, o Pokemon fugiu...");
                break;
        }
    }
}
