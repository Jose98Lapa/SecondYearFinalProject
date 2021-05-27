package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StreetTest {
    Street street = new Street("Rua das Vieiras");

    @Test
    public void test(){
        assertEquals(street,new Street("Rua das Vieiras"));
        assertNotEquals(street,new Street("Rua do Manuel"));
        assertThrows(IllegalArgumentException.class,() -> new Street(""));
        assertThrows(IllegalArgumentException.class,() -> new Street(null));
    }
}