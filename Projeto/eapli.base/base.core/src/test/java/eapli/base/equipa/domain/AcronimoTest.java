package eapli.base.equipa.domain;

import eapli.base.Servico.Domain.TituloServico;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AcronimoTest {
    Acronimo acronimo = new Acronimo("RTP");

    @Test
    public void test() {
        assertEquals(acronimo, new Acronimo("RTP"));
        assertNotEquals(acronimo, new Acronimo("RTP12"));
        assertThrows(IllegalArgumentException.class,() -> new Acronimo("a"));
        assertThrows(IllegalArgumentException.class,() -> new Acronimo(""));
        assertThrows(IllegalArgumentException.class,() -> new Acronimo(null));
    }

}