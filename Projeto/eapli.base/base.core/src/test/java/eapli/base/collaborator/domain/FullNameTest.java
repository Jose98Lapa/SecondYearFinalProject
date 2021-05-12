package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FullNameTest {
    FullName fullName = new FullName("José Miguel Freitas");

    @Test
    public void teste(){
        assertEquals(fullName, new FullName("José Miguel Freitas"));
        assertNotEquals(fullName, new FullName("José Castelo Branco"));
        assertThrows(IllegalArgumentException.class,() -> new FullName("José Freitas"));
        assertThrows(IllegalArgumentException.class,() -> new FullName(""));
        assertThrows(IllegalArgumentException.class,() -> new FullName(null));
    }
}