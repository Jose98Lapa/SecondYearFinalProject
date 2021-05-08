package eapli.base.colaborador.domain;

import eapli.base.equipa.domain.Acronimo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CodPostalTest {
    CodPostal codPostal = new CodPostal("4953-123");

    @Test
    public void test(){
        assertEquals(codPostal,new CodPostal("4953-123"));
        assertNotEquals(codPostal,new CodPostal("3212-123"));
        assertThrows(IllegalArgumentException.class,() -> new CodPostal("4324-23"));
        assertThrows(IllegalArgumentException.class,() -> new CodPostal("a"));
        assertThrows(IllegalArgumentException.class,() -> new CodPostal(""));
        assertThrows(IllegalArgumentException.class,() -> new CodPostal(null));
    }

}