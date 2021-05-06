package eapli.base.servico.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatusServicoTest {
    StatusServico StatusServico = new StatusServico("ACTIVE");

    @Test
    public void test() {
        assertEquals(StatusServico, new StatusServico("ACTIVE"));
        assertNotEquals(StatusServico, new StatusServico("INACTIVE"));
        assertThrows(IllegalArgumentException.class,() -> new StatusServico("A22"));
        assertThrows(IllegalArgumentException.class,() -> new StatusServico(" "));
        assertThrows(IllegalArgumentException.class,() -> new StatusServico(null));
    }

}