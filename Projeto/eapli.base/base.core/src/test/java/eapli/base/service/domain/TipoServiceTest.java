package eapli.base.service.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TipoServiceTest {
    ServiceType ServiceType = new ServiceType("AUTOMATICO");

    @Test
    public void test() {
        assertEquals(ServiceType, new ServiceType("AUTOMATICO"));
        assertNotEquals(ServiceType, new ServiceType("MANUAL"));
        assertThrows(IllegalArgumentException.class,() -> new ServiceType("A22"));
        assertThrows(IllegalArgumentException.class,() -> new ServiceType(" "));
        assertThrows(IllegalArgumentException.class,() -> new ServiceType(null));
    }

}