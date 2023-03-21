package program;

import models.JogoDado;
import models.JogoMegaSena;

public class Principal {
    public static void main(String[] args) {

        System.out.println("***** BEM-VINDO A CASA DE APOSTAS: $ BET LUCKY $ *****");
        JogoDado jd = new JogoDado();
        jd.iniciarPartida();
    }
}