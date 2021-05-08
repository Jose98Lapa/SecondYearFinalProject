package eapli.base.colaborador.domain;

import eapli.base.equipa.domain.Acronimo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumeroMecanograficoTest {
    NumeroMecanografico numMec = new NumeroMecanografico("123456");

    @Test
    public void test(){
        assertEquals(numMec,new NumeroMecanografico("123456"));
        assertNotEquals(numMec,new NumeroMecanografico("12345"));
        assertThrows(IllegalArgumentException.class,() -> new NumeroMecanografico("1234567"));
        assertThrows(IllegalArgumentException.class,() -> new NumeroMecanografico("a"));
        assertThrows(IllegalArgumentException.class,() -> new NumeroMecanografico(""));
        assertThrows(IllegalArgumentException.class,() -> new NumeroMecanografico(null));
    }
}