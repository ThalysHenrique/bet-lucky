package program;

import models.Loteria;

public class Principal {
    public static void main(String[] args) {

        System.out.println("***** BEM-VINDO A LOTERIA BET LUCKY *****");
        Loteria loteria = new Loteria();
        loteria.novaAposta();
    }
}