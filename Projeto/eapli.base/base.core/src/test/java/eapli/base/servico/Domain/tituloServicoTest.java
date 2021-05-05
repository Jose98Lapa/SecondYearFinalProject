package eapli.base.servico.Domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class tituloServicoTest {
    TituloServico ts = new TituloServico("ABCDGVWE");

    @Test
    public void test() {
        assertEquals(ts, new TituloServico("ABCDGVWE"));
        assertNotEquals(ts, new TituloServico("ABCDGVWEs"));
        assertThrows(IllegalArgumentException.class,() -> new TituloServico("ABCDGVWE123"));
        assertThrows(IllegalArgumentException.class,() -> new TituloServico(" "));
        assertThrows(IllegalArgumentException.class,() -> new TituloServico(null));
    }

}