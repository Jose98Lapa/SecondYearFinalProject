package eapli.base.criticidade.domain;

import eapli.base.colaborador.domain.Alcunha;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetivoDeAprovacaoTest {
    ObjetivoDeAprovacao objetivoDeAprovacao= new ObjetivoDeAprovacao("02:40","02:10");

    @Test
    public void test(){
        assertEquals(objetivoDeAprovacao, new ObjetivoDeAprovacao("02:40","02:10"));
        assertNotEquals(objetivoDeAprovacao, new ObjetivoDeAprovacao("02:40","02:00"));
        assertThrows(IllegalArgumentException.class,() -> new ObjetivoDeAprovacao("",""));
    }

}