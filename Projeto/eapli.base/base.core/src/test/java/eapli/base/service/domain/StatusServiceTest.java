package eapli.base.service.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatusServiceTest {
    ServiceStatus ServiceStatus = new ServiceStatus("ATIVO");

    @Test
    public void test() {
        assertEquals(ServiceStatus, new ServiceStatus("ATIVO"));
        assertNotEquals(ServiceStatus, new ServiceStatus("INATIVO"));
        assertThrows(IllegalArgumentException.class,() -> new ServiceStatus("A22"));
        assertThrows(IllegalArgumentException.class,() -> new ServiceStatus(" "));
        assertThrows(IllegalArgumentException.class,() -> new ServiceStatus(null));
    }

}