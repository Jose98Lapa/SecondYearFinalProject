package eapli.base.equipa.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EquipaIDTest {
    EquipaID acronimo = new EquipaID("123Ra");

    @Test
    public void test() {
        assertEquals(acronimo, new EquipaID("123Ra"));
        assertNotEquals(acronimo, new EquipaID("RTP12"));
        assertThrows(IllegalArgumentException.class,() -> new EquipaID("a"));
        assertThrows(IllegalArgumentException.class,() -> new EquipaID(""));
        assertThrows(IllegalArgumentException.class,() -> new EquipaID(null));
    }

}