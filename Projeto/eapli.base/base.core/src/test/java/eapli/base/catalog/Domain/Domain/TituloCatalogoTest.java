package eapli.base.catalog.Domain.Domain;

import eapli.base.catalog.domain.Title;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TituloCatalogoTest {
    Title ts = new Title("ABCDGVWE");

    @Test
    public void test1() {
        assertEquals(ts, new Title("ABCDGVWE"));
    }

    @Test
    public void test2() {
        assertNotEquals(ts, new Title("ABCDGVWEs"));
    }

    @Test
    public void test3() {
        assertThrows(IllegalArgumentException.class,() -> new Title("ABCDGVWE123"));
    }

    @Test
    public void test4() {
        assertThrows(IllegalArgumentException.class,() -> new Title(" "));
    }

    @Test
    public void tes5() {
        assertThrows(IllegalArgumentException.class,() -> new Title(null));
    }


}