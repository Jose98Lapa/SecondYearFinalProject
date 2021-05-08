package eapli.base.colaborador.domain;

import eapli.base.equipa.domain.Acronimo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocalizacaoTest {
    Localizacao localizacao = new Localizacao("Viana do Castelo");

    @Test
    public void test(){
        assertEquals(localizacao,new Localizacao("Viana do Castelo"));
        assertNotEquals(localizacao,new Localizacao("Porto"));
        assertThrows(IllegalArgumentException.class,() -> new Localizacao(""));
        assertThrows(IllegalArgumentException.class,() -> new Localizacao(null));
    }

}