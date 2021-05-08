package eapli.base.colaborador.domain;

import eapli.base.equipa.domain.Acronimo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstradaTest {
    Estrada estrada = new Estrada("Rua das Vieiras");

    @Test
    public void test(){
        assertEquals(estrada,new Estrada("Rua das Vieiras"));
        assertNotEquals(estrada,new Estrada("Rua do Manuel"));
        assertThrows(IllegalArgumentException.class,() -> new Estrada(""));
        assertThrows(IllegalArgumentException.class,() -> new Estrada(null));
    }
}