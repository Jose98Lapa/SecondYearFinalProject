package eapli.base.TipoEquipa.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoEquipaIDTest {
    TipoEquipaID tipoEquipaID = new TipoEquipaID("T12");

    @Test
    public void test(){
        assertEquals(tipoEquipaID, new TipoEquipaID("T12"));
        assertNotEquals(tipoEquipaID, new TipoEquipaID("T13"));
        assertThrows(IllegalArgumentException.class,() -> new TipoEquipaID("IDGRANDE"));
        assertThrows(IllegalArgumentException.class,() -> new TipoEquipaID(""));
        assertThrows(IllegalArgumentException.class,() -> new TipoEquipaID(null));
    }
}