package models;

import interfaces.*;

import java.util.Random;
import java.util.Scanner;

public class Loteria implements GeradorDeNumeros, ComparadorDeNumeros, Apostar {
    Random random = new Random();
    private int[] numerosAleatorios = new int[60];
    private int[] numerosSorteados = new int[6];
    private int[] numerosApostados = new int[6];
    private int acertos = 0;
    private int resposta = 0;

    /**
     * Método retorna números aleatórios
     * Limite: 60 números (1 a 60) -> conforme números da mega sena
     */
    @Override
    public void gerarNumerosAleatorios() {
        for(int i = 0; i < numerosAleatorios.length; i++){
            numerosAleatorios[i] = 1 + random.nextInt(60);
        }
    }

    /**
     * Método gera 6 números sorteados
     */
    @Override
    public void gerarNumerosSorteados() {
        for (int i = 0; i < numerosSorteados.length; i++) {
            numerosSorteados[i] = numerosAleatorios[i];
        }
    }

    /**
     * Método compara números sorteados e números inseridos pelo usuário
     */
    @Override
    public void compararNumeros() {
        for(int i = 0; i < numerosApostados.length; i++){
            for (int j = 0; i < numerosSorteados.length; i++){
                if(numerosApostados[i] == numerosSorteados[i]){
                    acertos++;
                }
            }
        }
        System.out.println("-> Você acertou: " + acertos + " número(s).");

    }

    /**
     * Método insere os números que o usuário deseja apostar
     */
    @Override
    public void apostar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-> ATENÇÃO, você deve escolher números entre 1 e 60. Boa sorte! ");
        System.out.print("-> Digite os números que deseja apostar: ");
            try {
                for (int i = 0; i < 6; i++) {
                    numerosApostados[i] = sc.nextInt();
                }
            } catch (Exception e){
                System.out.println("Ops, você deve digitar apenas NÚMEROS entre 1 e 60.");
                System.out.println("Mas não se preocupe, você pode tentar novamente, vamos lá? ");
            }
    }

    /**
     * Método para iniciar uma nova aposta
     */
    @Override
    public void novaAposta() {
        gerarNumerosAleatorios();
        gerarNumerosSorteados();
        apostar();
        compararNumeros();
        verificarPremio();

        System.out.println("-> Deseja realizar nova aposta? ");
        System.out.print("-> Digite: 1 - Sim || 2 - Não ");
        Scanner sc = new Scanner(System.in);
        resposta = sc.nextInt();

        switch (resposta){
            case 1:
                novaAposta();
                break;
            case 2:
                System.out.println("##### APOSTAS ENCERRADAS, OBRIGADO E VOLTE SEMPRE! #####");
                break;
        }
    }

    @Override
    public void verificarPremio() {
        if(acertos == 4){
            System.out.println("**** PARABÉNS, VOCÊ ACERTOU A QUADRA ****");
            System.out.println("**** Valor do prémio: R$ 877,04 ****");
        }
        if (acertos == 5){
            System.out.println("***** PARABÉNS, VOCÊ GANHOU A QUINA *****");
            System.out.println("***** Valor do prémio: R$ 45.438,78");
        }
        if(acertos == 6){
            System.out.println("****** PARABÉNS, VOCÊ É O(A) GRANDE VENCEDOR(A) DA MEGA SENA! ******");
            System.out.println("****** Valor do prémio: R$ 18.000.000,00 ******");
        }
    }
}
