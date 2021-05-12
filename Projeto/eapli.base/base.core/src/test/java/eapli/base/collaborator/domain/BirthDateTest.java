package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BirthDateTest {
    BirthDate birthDate = new BirthDate("12/12/1999");

    @Test
    public void test(){
        assertEquals(birthDate, new BirthDate("12/12/1999"));
        assertNotEquals(birthDate, new BirthDate("12/12/2000"));
        assertThrows(IllegalArgumentException.class,() -> new BirthDate("13/12/200"));
        assertThrows(IllegalArgumentException.class,() -> new BirthDate("32/12/2000"));
        assertThrows(IllegalArgumentException.class,() -> new BirthDate("13/13/2000"));
        assertThrows(IllegalArgumentException.class,() -> new BirthDate("a"));
        assertThrows(IllegalArgumentException.class,() -> new BirthDate(""));
        assertThrows(IllegalArgumentException.class,() -> new BirthDate(null));
    }

}