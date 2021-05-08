package eapli.base.funcao.domain;

import eapli.base.colaborador.domain.Alcunha;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesignacaoTest {
    Designacao desig = new Designacao("lavar janelas");

    @Test
    public void test(){
        assertEquals(desig,  new Designacao("lavar janelas"));
        assertNotEquals(desig,  new Designacao("lavar portas"));
        assertThrows(IllegalArgumentException.class,() -> new Designacao(""));
        assertThrows(IllegalArgumentException.class,() -> new Designacao(null));
    }

}