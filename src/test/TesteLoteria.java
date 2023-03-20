package test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

public class TesteLoteria {

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
}
