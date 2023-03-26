package models;

import interfaces.MecanicaDado;

import java.util.*;

public class JogoDado implements MecanicaDado {

    private List<Integer> dadoUm = new ArrayList<>();
    private List<Integer> duploDado = new ArrayList<>();
    private List<Integer> numeroApostado = new ArrayList<>();
    private Random random = new Random();
    private int qtdDado = 0;
    private int resposta = 0;


    /**
     * Método para iniciar a partida.
     * Usuário pode escolher entre jogar 1 ou 2 dados.
     * Método Try/Catch -> verifica se o usuário digitou algo diferente dos números 1 ou 2, caso sim,
     * retorna mensagem informando o erro e inicia novamente o método.
     */
    @Override
    public void iniciarPartida() {
        System.out.println("***** JOGO DO DADO *****");
        System.out.println("-> Para iniciar a partida informe quantos dados deseja jogar, O máximo é 2.");
        System.out.print("-> Escolha a quantidade: ");

        Scanner sc = new Scanner(System.in);
        try {
            qtdDado = Integer.parseInt(sc.nextLine());
            if(!(qtdDado == 1 || qtdDado == 2)){
                System.out.println("-> ATENÇÃO! Você deve digitar apenas o número 1 ou 2, tente novamente.");
                iniciarPartida();
            }
        } catch (NumberFormatException e){
            System.out.println("-> ATENÇÃO! Você deve digitar apenas o número 1 ou 2, tente novamente.");
            iniciarPartida();
        }

        /**
         * Caso o usuário tenha escolhido jogar 1 dado, ele deverá adivinhar qual o número que o dado irá cair, sendo 1 a 6,
         * para 2 dados, 2 a 12.
         */
        switch (qtdDado){
            case 1:
                jogarUmDado();
                System.out.println("-> Você escolheu jogar 1 dado, vamos iniciar...");
                System.out.print("-> Qual o número que o dado vai parar? Informe um valor de 1 a 6: ");

                try {
                    int numeroUd = sc.nextInt();
                    numeroApostado.add(numeroUd);
                } catch (InputMismatchException e){
                    System.out.println("-> ATENÇÃO! Você deve digitar um número de 1 a 6, tente novamente.");
                    zerarDadoUm();
                    iniciarPartida();
                }
                resultadoUmDado();
                zerarDadoUm();
                reiniciarPartida();
                break;
            case 2:
                jogarDadoDuplo();
                System.out.println("-> Você escolheu jogar 2 dados, vamos iniciar...");
                System.out.print("-> Qual o número que os dados vão parar? Informe um valor de 2 a 12: ");

                try {
                    int numeroDd = sc.nextInt();
                    numeroApostado.add(numeroDd);
                } catch (InputMismatchException e){
                    System.out.println("-> ATENÇÃO! Você deve digitar um número de 2 a 12, tente novamente.");
                    zerarDadoDuplo();
                    iniciarPartida();
                }
                resultadoDadoDuplo();
                zerarDadoDuplo();
                reiniciarPartida();
                break;
        }
        sc.close();
    }

    /**
     * Método para reiniciar a partida, caso o usuário deseje.
     * If -> verifica se o usuário digitou números diferentes de 1 ou 2.
     * Try/Catch -> verifica se usuário digitou caracter diferente de números
     */
    @Override
    public void reiniciarPartida() {
        System.out.println("-> Você deseja jogar novamente? ");
        System.out.print("-> Digite 1 - Sim || 2 - Não ");
        Scanner sc = new Scanner(System.in);
        try {
            resposta = sc.nextInt();
            if(!(resposta == 1 || resposta == 2)){
                System.out.println("-> Você deve escolher uma opção: 1 - Sim || 2 - Não");
                reiniciarPartida();
            }
        } catch (InputMismatchException e){
            System.out.println("-> Não entendi a sua resposta, poderia me falar novamente? ");
            reiniciarPartida();
        }
        switch (resposta){
            case 1:
                zerarNumeroApostado(); // Zera o número inserido na partida anterior.
                iniciarPartida();
                break;
            case 2:
                // resposta = 0 -> Caso o usuário digite outros caracteres, além dos números 1 ou 2 por diversas vezes,
                // impedirá que as mensagens de saída do case 2 sejam guardadas em memória e imprimidas várias vezes.
                resposta = 0;
                System.out.println("* A Bet Lucky agradece a sua presença *");
                System.out.println("* Muito obrigado e volte sempre! *");
                break;
        }
        sc.close();
    }

    /**
     * Método para jogar 1 dado.
     * É gerado um número aleatório de 1 a 6 para o usuário adivinhar.
     */
    @Override
    public void jogarUmDado() {
        int numero = 1 + random.nextInt(6);
        dadoUm.add(numero);
        System.out.println(dadoUm);
    }

    /**
     * Método para jogar 2 dados.
     * É gerado um número de 2 a 12 para o usuário adivinhar.
     */
    @Override
    public void jogarDadoDuplo() {
        int numero = 2 + random.nextInt(12);
        duploDado.add(numero);
        System.out.println(duploDado);
    }

    /**
     * Método para verificar se o usuário acertou o número que o dado caiu.
     */
    @Override
    public void resultadoUmDado(){
        if(numeroApostado.equals(dadoUm)){
            System.out.println("Você acertou o número.");
        } else {
            System.out.println("Você errou o número.");
        }
    }

    /**
     * Método para verificar se o usuário acertou o número que os dados cairam.
     */
    @Override
    public void resultadoDadoDuplo(){
        if (numeroApostado.equals(duploDado)){
            System.out.println("Você acertou o número.");
        } else {
            System.out.println("Você errou o número.");
        }
    }

    /**
     * Método para zerar o DadoUm, caso o usuário deseje reiniciar a partida.
     * Impede que o número já gerado fique guardado em memória sendo imprimido na próxima rodada.
     */
    @Override
    public void zerarDadoUm() {
        dadoUm.clear();
    }

    /**
     * Método para zerar o DadoDuplo, caso o usuário deseje reiniciar a partida.
     * Impede que o número já gerado fique guardado em memória sendo imprimido na próxima rodada.
     */
    @Override
    public void zerarDadoDuplo() {
        duploDado.clear();
    }

    /**
     * Método para zerar o número apostado pelo usuário, caso ele deseje reiniciar a partida.
     * Impede que o número já inserido fique guardado em memória e seja interferido o resultado da próxima rodada.
     */
    @Override
    public void zerarNumeroApostado() {
        numeroApostado.clear();
    }
}
