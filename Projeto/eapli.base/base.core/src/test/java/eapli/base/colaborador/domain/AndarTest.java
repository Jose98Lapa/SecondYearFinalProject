package eapli.base.colaborador.domain;

import eapli.base.equipa.domain.Acronimo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AndarTest {
    Andar andar = new Andar("3");

    @Test
    public void test(){
        assertEquals(andar,new Andar("3"));
        assertNotEquals(andar,new Andar("4"));
        assertThrows(IllegalArgumentException.class,() -> new Andar("1000000"));
        assertThrows(IllegalArgumentException.class,() -> new Andar("a"));
        assertThrows(IllegalArgumentException.class,() -> new Andar(""));
        assertThrows(IllegalArgumentException.class,() -> new Andar(null));
    }

}