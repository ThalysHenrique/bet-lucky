package test;

import models.JogoMegaSena;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

public class TesteMegaSena {

    @Test
    public void testNumerosSorteados() {
        Set<Integer> numerosSorteados = new HashSet<>();
        Random random = new Random();
        for(int i = 0; i < 6; i++){
            int numeros = 1 + random.nextInt(60);
            numerosSorteados.add(numeros);
        }
        System.out.println(numerosSorteados);

        assertEquals(6, numerosSorteados.size());
    }

    @Test
    public void testAcertos() {
        Set<Integer> numerosSorteados = new HashSet<>();
        Set<Integer> numerosApostados = new HashSet<>();
        Random random = new Random();
        for(int i = 0; i < 6; i++){
            int numeros = 1 + random.nextInt(60);
            numerosSorteados.add(numeros);
        }
        System.out.println(numerosSorteados);
    }

    @Test
    public void testePremio(){
        JogoMegaSena jms = new JogoMegaSena();
        int acertos = 6;
        double premio = jms.verificarPremio();

        assertEquals(10000, premio, 0);
    }
}
