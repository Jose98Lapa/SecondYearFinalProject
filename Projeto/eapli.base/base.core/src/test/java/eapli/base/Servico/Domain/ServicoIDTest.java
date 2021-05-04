package eapli.base.Servico.Domain;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ServicoIDTest {
    ServicoID id = new ServicoID("Aa-32");

    @Test
    public void test() {
        assertEquals(id, new ServicoID("Aa-32"));
        assertNotEquals(id, new ServicoID("Aa-2"));
        assertThrows(IllegalArgumentException.class,() -> new ServicoID("Aa-32!"));
        assertThrows(IllegalArgumentException.class,() -> new ServicoID(" "));
        assertThrows(IllegalArgumentException.class,() -> new ServicoID(null));
    }

}