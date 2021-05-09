package eapli.base.catalogo.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TituloTest {

    @Test
    public void ensureTitleCanHavePontuation() {
        System.out.println("Title can have pontuation");
        Titulo result = new Titulo("É um bom titulo!");
        String expected = "É um bom titulo!";
        assertEquals(result.toString(),expected);
    }

    @Test
    public void ensureTitleCanHaveAccent() {
        System.out.println("Title can have accents");
        Titulo result = new Titulo("É um bom titulo");
        String expected = "É um bom titulo";
        assertEquals(result.toString(),expected);
    }

    @Test
    public void ensureTitleCannotBeToLong() {
        System.out.println("Title can not be too long");
        assertThrows(IllegalArgumentException.class,() -> new Titulo("Este titulo é demasiado grande"));
    }

    @Test
    public void ensureTitleCannotBeEmpty() {
        System.out.println("Title can not be empty");
        assertThrows(IllegalArgumentException.class,() -> new Titulo(" "));
    }

    @Test
    public void ensureTitleCannotBeNull() {
        System.out.println("Title can not be null");
        assertThrows(IllegalArgumentException.class,() -> new Titulo(null));
    }

}