package eapli.base.servicecatalog.Domain.Domain;

import eapli.base.servicecatalog.domain.TituloCatalogo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TituloCatalogoTest {
    TituloCatalogo ts = new TituloCatalogo("ABCDGVWE");

    @Test
    public void test1() {
        assertEquals(ts, new TituloCatalogo("ABCDGVWE"));
    }

    @Test
    public void test2() {
        assertNotEquals(ts, new TituloCatalogo("ABCDGVWEs"));
    }

    @Test
    public void test3() {
        assertThrows(IllegalArgumentException.class,() -> new TituloCatalogo("ABCDGVWE123"));
    }

    @Test
    public void test4() {
        assertThrows(IllegalArgumentException.class,() -> new TituloCatalogo(" "));
    }

    @Test
    public void tes5() {
        assertThrows(IllegalArgumentException.class,() -> new TituloCatalogo(null));
    }


}