package models;

import interfaces.Apostar;
import interfaces.GeradorDeNumeros;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Loteria implements GeradorDeNumeros, Apostar {

    private Set<Integer> numerosSorteados = new HashSet<>();
    private Set<Integer> numerosApostados = new HashSet<>();
    Random random = new Random();
    private int acertos = 0;
    private int resposta = 0;

    /**
     * Método retorna números aleatórios.
     * Números (1 a 60)
     */
    @Override
    public void gerarNumerosSorteados() {
        for(int i = 0; i < 6; i++){
            int numeros = 1 + random.nextInt(60);
            numerosSorteados.add(numeros); // -> Gera 6 números aleatórios a partir de 1 até 60 e guarda em uma Set List.

        }
        System.out.println(numerosSorteados);
    }

    @Override
    public void reiniciarNumerosSorteados() {
        numerosSorteados.clear();
    }

    /**
     * Método compara números sorteados e números inseridos pelo usuário.
     */
    @Override
    public void compararNumeros() {
        for(int i = 0; i < numerosSorteados.size(); i++){
            if(numerosApostados.equals(numerosSorteados)){
                acertos++; // -> Caso os números apostados forem iguais aos números sorteados, soma o acerto.
            }
        }
        System.out.println("-> Você acertou: " + acertos + " número(s).");
    }

    /**
     * Método insere os números que o usuário deseja apostar.
     * Tratamento de Exceção -> verifica se o usuário digitou algum caractere diferente de número,
     * Caso sim, retorna uma mensagem informando o erro e reinicia o programa.
     */
    @Override
    public void apostar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-> ATENÇÃO, você deve escolher números entre 1 e 60. Boa sorte! ");
        System.out.print("-> Digite os números que deseja apostar: ");
            try {
                for (int i = 0; i < 6; i++) {
                    int numeros = sc.nextInt();
                    if(numeros > 0 && numeros <= 60) { // -> Adiciona os números apenas se o usuário digitar entre 1 e 60.
                        numerosApostados.add(numeros);
                    } else {
                        i--; // -> Caso o usuário digite um número menor que 0 ou maior que 60, retorna mensagem informando erro e ignora este número.
                        System.out.println("-> ATENÇÃO, você deve escolher números entre 1 e 60.");
                    }
                }
            } catch (Exception e){
                System.out.println("Ops, você deve digitar apenas NÚMEROS entre 1 e 60.");
                System.out.println("Mas não se preocupe, você pode tentar novamente, vamos lá? ");
            }
    }

    /**
     * Método para iniciar uma nova aposta.
     * Ao final da aposta, verifica se o usuário ganhou algum prémio e pergunta se ele quer realizar nova aposta.
     * 1 -> Sim (Inicia uma nova aposta).
     * 2 -> Não (Finaliza a execução do programa).
     */
    @Override
    public void novaAposta() {
        gerarNumerosSorteados();
        apostar();
        compararNumeros();
        verificarPremio();

        System.out.println("-> Deseja realizar nova aposta? ");
        System.out.print("-> Digite: 1 - Sim || 2 - Não "); // -> Ao final da aposta, pergunta ao usuário se deseja apostar novamente.

        Scanner sc = new Scanner(System.in);
        try {
            resposta = sc.nextInt(); // -> Pega a resposta do usuário, 1 - inicia nova aposta e 2 - finaliza as apostas.
        } catch (Exception e){
            System.out.println("Resposta inválida, sessão encerrada!"); // -> Caso o usuário não digite nenhuma das 2 opções, programa é encerrado.
        }

        switch (resposta){
            case 1:
                reiniciarNumerosSorteados();
                novaAposta();
                break;
            case 2:
                System.out.println("##### APOSTAS ENCERRADAS, OBRIGADO E VOLTE SEMPRE! #####");
                break;
        }
    }

    /**
     * Método verifica se o usuário recebeu algum prémio.
     * 4 acertos -> Quadra, recebe R$ 12,876,00.
     * 5 acertos -> Quina, recebe R$ 45.438,00.
     * 6 acertos -> Mega Sena, recebe R$ 182.990,00.
     */
    @Override
    public void verificarPremio() {
        if(acertos == 4){
            double premioQuadra = 12.876;
            System.out.println("**** PARABÉNS, VOCÊ ACERTOU A QUADRA ****");
            System.out.println("**** Valor do prémio: R$ " + premioQuadra + " ****");
        }
        if (acertos == 5){
            double premioQuina = 45.438;
            System.out.println("***** PARABÉNS, VOCÊ GANHOU A QUINA *****");
            System.out.println("***** Valor do prémio: R$ " + premioQuina + " *****");
        }
        if(acertos == 6){
            double premioMegaSena = 182990;
            System.out.println("****** PARABÉNS, VOCÊ É O(A) GRANDE VENCEDOR(A) DA MEGA SENA! ******");
            System.out.println("****** Valor do prémio: R$ " + premioMegaSena + " ******");
        }
    }
}
