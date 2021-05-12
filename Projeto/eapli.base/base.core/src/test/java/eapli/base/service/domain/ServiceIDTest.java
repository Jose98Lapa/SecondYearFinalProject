package eapli.base.service.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceIDTest {
    ServiceID id = new ServiceID("32");

    @Test
    public void test() {
        assertEquals(id, new ServiceID("32"));
        assertNotEquals(id, new ServiceID("2"));
        assertThrows(IllegalArgumentException.class,() -> new ServiceID("Aa32!"));
        assertThrows(IllegalArgumentException.class,() -> new ServiceID(" "));
        assertThrows(IllegalArgumentException.class,() -> new ServiceID(null));
    }

}