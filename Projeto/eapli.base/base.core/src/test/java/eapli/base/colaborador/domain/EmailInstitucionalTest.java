package eapli.base.colaborador.domain;

import eapli.base.equipa.domain.Acronimo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailInstitucionalTest {

    EmailInstitucional email = new EmailInstitucional("tomy@gmail.com");

    @Test
    public void test(){
        assertEquals(email, new EmailInstitucional("tomy@gmail.com"));
        assertNotEquals(email, new EmailInstitucional("tiago@gmail.com"));
        assertThrows(IllegalArgumentException.class,() -> new EmailInstitucional("tiago@gmail"));
        assertThrows(IllegalArgumentException.class,() -> new EmailInstitucional("a"));
        assertThrows(IllegalArgumentException.class,() -> new EmailInstitucional(""));
        assertThrows(IllegalArgumentException.class,() -> new EmailInstitucional(null));
    }
}