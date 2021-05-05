package eapli.base.servico.Domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TipoServicoTest {
    TipoServico TipoServico = new TipoServico("AUTOMATICO");

    @Test
    public void test() {
        assertEquals(TipoServico, new TipoServico("AUTOMATICO"));
        assertNotEquals(TipoServico, new TipoServico("MANUAL"));
        assertThrows(IllegalArgumentException.class,() -> new TipoServico("A22"));
        assertThrows(IllegalArgumentException.class,() -> new TipoServico(" "));
        assertThrows(IllegalArgumentException.class,() -> new TipoServico(null));
    }

}