package eapli.base.colaborador.domain;

import eapli.base.colaborador.dto.MoradaDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoradaTest {
    Morada morada = new Morada("Rua Galego","2","3","Viana do Castelo","4953-231");

    @Test
    public void test(){
        assertEquals(morada,new Morada("Rua Galego","2","3","Viana do Castelo","4953-231"));
        assertNotEquals(morada,new Morada("Rua dos Galego","2","3","Viana do Castelo","4953-231"));
        assertThrows(IllegalArgumentException.class,() -> new Morada("","","","",""));
    }

    @Test
    void toDTO() {
        MoradaDTO expected = new MoradaDTO("Rua Galego","2","3","Viana do Castelo","4953-231");
        MoradaDTO notExpected = new MoradaDTO("Rua dos Galego","2","3","Viana do Castelo","4953-231");
        MoradaDTO actual = morada.toDTO();
        assertEquals(expected.andar,actual.andar);
        assertEquals(expected.codPostal,actual.codPostal);
        assertEquals(expected.localizacao,actual.localizacao);
        assertEquals(expected.rua,actual.rua);
        assertEquals(expected.numPorta,actual.numPorta);
        assertNotEquals(notExpected,actual);
    }
}