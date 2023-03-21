package models;

import interfaces.MecanicaDado;

import java.util.*;

public class JogoDado implements MecanicaDado {

    private List<Integer> dadoUm = new LinkedList<>();
    private List<Integer> duploDado = new LinkedList<>();
    Random random = new Random();
    private int qtdDado = 0;
    private int resposta = 0;


    @Override
    public void iniciarPartida() {
        System.out.println("***** JOGO DO DADO *****");
        System.out.println("-> Para iniciar a partida informe quantos dados deseja jogar, O máximo é 2.");
        System.out.println("-> Escolha a quantidade: ");

        Scanner sc = new Scanner(System.in);
        qtdDado = sc.nextInt();

        sc.close();
        switch (qtdDado){
            case 1:
                System.out.println("-> Você escolheu jogar 1 dado, vamos iniciar...");
                System.out.println("-> Qual o número que o dado vai parar? Informe um valor de 1 a 6.");
                jogarUmDado();
                break;
            case 2:
                System.out.println("-> Você escolheu jogar 2 dados, vamos iniciar...");
                System.out.println("-> Qual o número que os dados vão parar? Informe um valor de 2 a 12.");
                jogarDoisDados();
                break;
        }
    }

    @Override
    public void reiniciarPartida() {
        System.out.println("-> Você deseja jogar novamente? ");
        System.out.println("-> Digite 1 - Sim || 2 - Não ");
        switch (resposta){
            case 1:
                iniciarPartida();
                break;
            case 2:
                System.out.println("* A Bet Lucky agradece a sua presença *");
                System.out.println("* Muito obrigado e volte sempre *");
        }
    }

    @Override
    public void jogarUmDado() {
        int numero = 1 + random.nextInt(6);
        dadoUm.add(numero);
    }

    @Override
    public void jogarDoisDados() {
        int numero = 2 + random.nextInt(12);
        duploDado.add(numero);
    }
}
