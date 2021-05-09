package eapli.base.catalogo.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DescricaoCompletaTest {

    @Test
    public void ensureDescriptionCannotBeEmpty() {
        System.out.println("Complete description can not be empty");
        assertThrows(IllegalArgumentException.class,() -> new DescricaoCompleta(" "));
    }

    @Test
    public void ensureDescriptionCannotBeNull() {
        System.out.println("Complete description can not be null");
        assertThrows(IllegalArgumentException.class,() -> new DescricaoCompleta(null));
    }

}