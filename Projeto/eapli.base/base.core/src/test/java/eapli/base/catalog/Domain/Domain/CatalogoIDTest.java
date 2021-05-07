package eapli.base.catalog.Domain.Domain;

import eapli.base.catalogo.domain.CatalogoID;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoIDTest {
    CatalogoID id = new CatalogoID("Aa-32");

    @Test
    public void ensure() {
        assertEquals(id, new CatalogoID("Aa-32"));
    }

    @Test
    public void test2() {
        assertNotEquals(id, new CatalogoID("Aa-2"));
    }

    @Test
    public void test3() {
        assertThrows(IllegalArgumentException.class,() -> new CatalogoID("Aa-32!"));
    }

    @Test
    public void test4() {
        //assertThrows(IllegalArgumentException.class,() -> new CatalogoID(" "));
    }

    @Test
    public void tes5() {
        assertThrows(IllegalArgumentException.class,() -> new CatalogoID(null));
    }

}