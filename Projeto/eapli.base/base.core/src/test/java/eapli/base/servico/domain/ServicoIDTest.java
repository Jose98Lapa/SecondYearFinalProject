package eapli.base.servico.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServicoIDTest {
    ServicoID id = new ServicoID("32");

    @Test
    public void test() {
        assertEquals(id, new ServicoID("32"));
        assertNotEquals(id, new ServicoID("2"));
        assertThrows(IllegalArgumentException.class,() -> new ServicoID("Aa32!"));
        assertThrows(IllegalArgumentException.class,() -> new ServicoID(" "));
        assertThrows(IllegalArgumentException.class,() -> new ServicoID(null));
    }

}