package eapli.base.colaborador.domain;

import eapli.base.equipa.domain.Acronimo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactoTest {
    Contacto contacto = new Contacto("921234567");

    @Test
    public void test(){
        assertEquals(contacto, new Contacto("921234567"));
        assertNotEquals(contacto, new Contacto("921234565"));
        assertThrows(IllegalArgumentException.class,() -> new Contacto("9212345612"));
        assertThrows(IllegalArgumentException.class,() -> new Contacto("92123456"));
        assertThrows(IllegalArgumentException.class,() -> new Contacto("a"));
        assertThrows(IllegalArgumentException.class,() -> new Contacto(""));
        assertThrows(IllegalArgumentException.class,() -> new Contacto(null));
    }

}