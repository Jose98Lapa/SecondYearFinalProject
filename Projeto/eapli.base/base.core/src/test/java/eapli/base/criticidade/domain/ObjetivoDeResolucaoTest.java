package eapli.base.criticidade.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetivoDeResolucaoTest {
    ObjetivoDeResolucao objetivoDeResolucao= new ObjetivoDeResolucao("02:40","02:10");

    @Test
    public void test(){
        assertEquals(objetivoDeResolucao, new ObjetivoDeResolucao("02:40","02:10"));
        assertNotEquals(objetivoDeResolucao, new ObjetivoDeResolucao("02:40","02:00"));
        assertThrows(IllegalArgumentException.class,() -> new ObjetivoDeResolucao(" "," "));
    }

}