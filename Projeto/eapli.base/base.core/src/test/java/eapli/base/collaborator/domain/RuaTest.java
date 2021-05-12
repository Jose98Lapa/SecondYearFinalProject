package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RuaTest {
    Rua rua = new Rua("Rua das Vieiras");

    @Test
    public void test(){
        assertEquals(rua,new Rua("Rua das Vieiras"));
        assertNotEquals(rua,new Rua("Rua do Manuel"));
        assertThrows(IllegalArgumentException.class,() -> new Rua(""));
        assertThrows(IllegalArgumentException.class,() -> new Rua(null));
    }
}