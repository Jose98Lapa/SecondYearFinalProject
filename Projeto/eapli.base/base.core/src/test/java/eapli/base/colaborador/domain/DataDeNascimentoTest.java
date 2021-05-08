package eapli.base.colaborador.domain;

import eapli.base.equipa.domain.Acronimo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataDeNascimentoTest {
    DataDeNascimento dataDeNascimento = new DataDeNascimento("12/12/1999");

    @Test
    public void test(){
        assertEquals(dataDeNascimento, new DataDeNascimento("12/12/1999"));
        assertNotEquals(dataDeNascimento, new DataDeNascimento("12/12/2000"));
        assertThrows(IllegalArgumentException.class,() -> new DataDeNascimento("13/12/200"));
        assertThrows(IllegalArgumentException.class,() -> new DataDeNascimento("32/12/2000"));
        assertThrows(IllegalArgumentException.class,() -> new DataDeNascimento("13/13/2000"));
        assertThrows(IllegalArgumentException.class,() -> new DataDeNascimento("a"));
        assertThrows(IllegalArgumentException.class,() -> new DataDeNascimento(""));
        assertThrows(IllegalArgumentException.class,() -> new DataDeNascimento(null));
    }

}