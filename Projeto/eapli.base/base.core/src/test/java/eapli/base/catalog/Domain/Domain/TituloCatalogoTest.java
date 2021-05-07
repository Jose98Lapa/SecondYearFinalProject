package eapli.base.catalog.Domain.Domain;

import eapli.base.catalogo.domain.Titulo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TituloCatalogoTest {
    Titulo ts = new Titulo("ABCDGVWE");

    @Test
    public void test1() {
        assertEquals(ts, new Titulo("ABCDGVWE"));
    }

    @Test
    public void test2() {
        assertNotEquals(ts, new Titulo("ABCDGVWEs"));
    }

    @Test
    public void test3() {
        assertThrows(IllegalArgumentException.class,() -> new Titulo("ABCDGVWE123"));
    }

/*    @Test
    public void test4() {
        assertThrows(IllegalArgumentException.class,() -> new Titulo(" "));
    }*/

    @Test
    public void tes5() {
        assertThrows(IllegalArgumentException.class,() -> new Titulo(null));
    }


}