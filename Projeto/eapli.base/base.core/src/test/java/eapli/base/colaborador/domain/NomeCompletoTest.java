package eapli.base.colaborador.domain;

import eapli.base.equipa.domain.Acronimo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NomeCompletoTest {
    NomeCompleto nomeCompleto = new NomeCompleto("José Miguel Freitas");

    @Test
    public void teste(){
        assertEquals(nomeCompleto, new NomeCompleto("José Miguel Freitas"));
        assertNotEquals(nomeCompleto, new NomeCompleto("José Castelo Branco"));
        assertThrows(IllegalArgumentException.class,() -> new NomeCompleto("José Freitas"));
        assertThrows(IllegalArgumentException.class,() -> new NomeCompleto(""));
        assertThrows(IllegalArgumentException.class,() -> new NomeCompleto(null));
    }
}