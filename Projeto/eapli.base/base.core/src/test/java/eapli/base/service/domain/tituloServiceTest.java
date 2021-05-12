package eapli.base.service.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class tituloServiceTest {
    ServiceTitle ts = new ServiceTitle("ABCDGVWE");

    @Test
    public void test() {
        assertEquals(ts, new ServiceTitle("ABCDGVWE"));
        assertNotEquals(ts, new ServiceTitle("ABCDGVWEs"));
        assertThrows(IllegalArgumentException.class,() -> new ServiceTitle("ABCDGVWE123"));
        assertThrows(IllegalArgumentException.class,() -> new ServiceTitle(""));
        assertThrows(IllegalArgumentException.class,() -> new ServiceTitle(null));
    }

}