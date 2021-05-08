package eapli.base.colaborador.domain;

import eapli.base.equipa.domain.Acronimo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumPortaTest {
    NumPorta numPorta = new NumPorta("2");

    @Test
    public void teste(){
        assertEquals(numPorta,new NumPorta("2"));
        assertNotEquals(numPorta,new NumPorta("20"));
        assertThrows(IllegalArgumentException.class,() -> new NumPorta("2000000"));
        assertThrows(IllegalArgumentException.class,() -> new NumPorta("a"));
        assertThrows(IllegalArgumentException.class,() -> new NumPorta(""));
        assertThrows(IllegalArgumentException.class,() -> new NumPorta(null));
    }

}