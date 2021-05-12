package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MecanographicNumberTest {
    MecanographicNumber numMec = new MecanographicNumber("123456");

    @Test
    public void test(){
        assertEquals(numMec,new MecanographicNumber("123456"));
        assertNotEquals(numMec,new MecanographicNumber("12345"));
        assertThrows(IllegalArgumentException.class,() -> new MecanographicNumber("1234567"));
        assertThrows(IllegalArgumentException.class,() -> new MecanographicNumber("a"));
        assertThrows(IllegalArgumentException.class,() -> new MecanographicNumber(""));
        assertThrows(IllegalArgumentException.class,() -> new MecanographicNumber(null));
    }
}