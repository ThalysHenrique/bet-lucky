package models;

import interfaces.MecanicaDado;

import java.util.*;

public class JogoDado implements MecanicaDado {

    private List<Integer> dadoUm = new ArrayList<>();
    private List<Integer> duploDado = new ArrayList<>();
    private List<Integer> numeroApostado = new ArrayList<>();
    Random random = new Random();
    private int qtdDado = 0;
    private int resposta = 0;


    @Override
    public void iniciarPartida() {
        System.out.println("***** JOGO DO DADO *****");
        System.out.println("-> Para iniciar a partida informe quantos dados deseja jogar, O máximo é 2.");
        System.out.print("-> Escolha a quantidade: ");

        Scanner sc = new Scanner(System.in);
        qtdDado = Integer.parseInt(sc.nextLine());

        switch (qtdDado){
            case 1:
                jogarUmDado();
                System.out.println("-> Você escolheu jogar 1 dado, vamos iniciar...");
                System.out.print("-> Qual o número que o dado vai parar? Informe um valor de 1 a 6: ");
                int numeroUd = sc.nextInt();
                numeroApostado.add(numeroUd);
                resultadoUmDado();
                zerarDadoUm();
                reiniciarPartida();
                break;
            case 2:
                jogarDadoDuplo();
                System.out.println("-> Você escolheu jogar 2 dados, vamos iniciar...");
                System.out.print("-> Qual o número que os dados vão parar? Informe um valor de 2 a 12: ");

                int numeroDd = sc.nextInt();
                numeroApostado.add(numeroDd);
                resultadoDadoDuplo();
                zerarDadoDuplo();
                reiniciarPartida();
                break;
        }
        sc.close();
    }

    @Override
    public void reiniciarPartida() {
        System.out.println("-> Você deseja jogar novamente? ");
        System.out.print("-> Digite 1 - Sim || 2 - Não ");
        Scanner sc = new Scanner(System.in);
        resposta = sc.nextInt();
        switch (resposta){
            case 1:
                iniciarPartida();
                break;
            case 2:
                System.out.println("* A Bet Lucky agradece a sua presença *");
                System.out.println("* Muito obrigado e volte sempre *");
        }
        sc.close();
    }

    @Override
    public void jogarUmDado() {
        int numero = 1 + random.nextInt(6);
        dadoUm.add(numero);
        System.out.println(dadoUm);
    }

    @Override
    public void jogarDadoDuplo() {
        int numero = 2 + random.nextInt(12);
        duploDado.add(numero);
        System.out.println(duploDado);
    }

    @Override
    public void resultadoUmDado(){
        if(numeroApostado.equals(dadoUm)){
            System.out.println("Você acertou o número.");
        } else {
            System.out.println("Você errou o número.");
        }
    }

    @Override
    public void resultadoDadoDuplo(){
        if (numeroApostado.equals(duploDado)){
            System.out.println("Você acertou o número.");
        } else {
            System.out.println("Você errou o número.");
        }
    }

    @Override
    public void zerarDadoUm() {
        dadoUm.clear();
    }

    @Override
    public void zerarDadoDuplo() {
        duploDado.clear();
    }
}
