package program;

import models.JogoDado;
import models.JogoMegaSena;

import java.util.Scanner;

public class Principal {
    static int resposta = 0;
    public static void main(String[] args) {

        System.out.println("***** BEM-VINDO A CASA DE APOSTAS: $ BET LUCKY $ *****");
        System.out.print("-> Escolha um jogo para apostar: 1 - Jogo da MegaSena || 2 - Jogo do Dado");
        Scanner sc = new Scanner(System.in);
        resposta = sc.nextInt();
        switch (resposta){
            case 1:
                JogoMegaSena jms = new JogoMegaSena();
                jms.novaAposta();
                break;
            case 2:
                JogoDado jd = new JogoDado();
                jd.iniciarPartida();
                break;
        }
        sc.close();
    }
}