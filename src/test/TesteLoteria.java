package test;

import models.Loteria;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TesteLoteria {

    Loteria loteria;

    @Before
    @Test
    public void inicializaLoteria(){
        loteria = new Loteria();
    }

    @Test
    public void testNumerosAleatoriosAte60() {
        loteria.gerarNumerosSorteados();

        Random random = new Random();
        int[] numerosGerados = new int[60];

        for (int i = 0; i < numerosGerados.length; i++){
            numerosGerados[i] = 1 + random.nextInt(60);
            System.out.println(i + 1 + "º número gerado: [" + numerosGerados[i] + "]" + " ");
        }

        assertEquals(numerosGerados.length, 60);
    }
}
