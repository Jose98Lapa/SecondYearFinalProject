package eapli.base.criticidade.domain;

import eapli.base.colaborador.domain.Alcunha;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValorCriticidadeTest {
    ValorCriticidade valorCriticidade = new ValorCriticidade("1");

    @Test
    public void test(){
        assertEquals(valorCriticidade, new ValorCriticidade("1"));
        assertNotEquals(valorCriticidade, new ValorCriticidade("2"));
        assertThrows(IllegalArgumentException.class,() -> new ValorCriticidade("a"));
        assertThrows(IllegalArgumentException.class,() -> new ValorCriticidade(""));
        assertThrows(IllegalArgumentException.class,() -> new ValorCriticidade(null));
    }
}