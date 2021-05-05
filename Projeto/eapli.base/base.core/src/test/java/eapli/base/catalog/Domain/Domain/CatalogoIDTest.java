package eapli.base.catalog.Domain.Domain;

import eapli.base.catalog.domain.CatalogID;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoIDTest {
    CatalogID id = new CatalogID("Aa-32");

    @Test
    public void ensure() {
        assertEquals(id, new CatalogID("Aa-32"));
    }

    @Test
    public void test2() {
        assertNotEquals(id, new CatalogID("Aa-2"));
    }

    @Test
    public void test3() {
        assertThrows(IllegalArgumentException.class,() -> new CatalogID("Aa-32!"));
    }

    @Test
    public void test4() {
        //assertThrows(IllegalArgumentException.class,() -> new CatalogoID(" "));
    }

    @Test
    public void tes5() {
        assertThrows(IllegalArgumentException.class,() -> new CatalogID(null));
    }

}