package eapli.base.colaborador.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlcunhaTest {
    Alcunha alcunha = new Alcunha("Tomy");

    @Test
    public void test(){
        assertEquals(alcunha, new Alcunha("Tomy"));
        assertNotEquals(alcunha, new Alcunha("Johny"));
        assertThrows(IllegalArgumentException.class,() -> new Alcunha(""));
        assertThrows(IllegalArgumentException.class,() -> new Alcunha(null));
    }
}