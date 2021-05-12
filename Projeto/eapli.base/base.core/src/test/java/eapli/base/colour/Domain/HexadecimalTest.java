package eapli.base.colour.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HexadecimalTest {
    private String valorHexadecimal="0000FF";

    @Test
    public void teste(){
        assertNotEquals(valorHexadecimal, new Hexadecimal("0000FE"));
        assertThrows(IllegalArgumentException.class,() -> new Hexadecimal("0000FER"));
        assertThrows(IllegalArgumentException.class,() -> new Hexadecimal("a"));
        assertThrows(IllegalArgumentException.class,() -> new Hexadecimal(""));
        assertThrows(IllegalArgumentException.class,() -> new Hexadecimal(null));
    }

}