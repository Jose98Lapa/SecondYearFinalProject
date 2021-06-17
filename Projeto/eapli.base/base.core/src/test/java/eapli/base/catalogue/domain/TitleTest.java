package eapli.base.catalogue.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TitleTest {

    @Test
    public void ensureTitleCanHavePontuation() {
        System.out.println("Title can have pontuation");
        Title result = new Title("É um bom titulo!");
        String expected = "É um bom titulo!";
        assertEquals(result.toString(),expected);
    }

    @Test
    public void ensureTitleCanHaveAccent() {
        System.out.println("Title can have accents");
        Title result = new Title("É um bom titulo");
        String expected = "É um bom titulo";
        assertEquals(result.toString(),expected);
    }

    @Test
    public void ensureTitleCannotBeToLong() {
        System.out.println("Title can not hjkkkkkjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj be too long");
        assertThrows(IllegalArgumentException.class,() -> new Title("Este titulo é demasiado grande"));
    }

    @Test
    public void ensureTitleCannotBeEmpty() {
        System.out.println("Title can not be empty");
        assertThrows(IllegalArgumentException.class,() -> new Title(" "));
    }

    @Test
    public void ensureTitleCannotBeNull() {
        System.out.println("Title can not be null");
        assertThrows(IllegalArgumentException.class,() -> new Title(null));
    }

}