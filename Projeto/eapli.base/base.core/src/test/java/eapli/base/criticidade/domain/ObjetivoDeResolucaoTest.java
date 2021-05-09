package eapli.base.criticidade.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetivoDeResolucaoTest {
    ObjetivoDeResolucao objetivoDeResolucao= new ObjetivoDeResolucao("02:40","02:10");

    @Test
    public void test(){
        assertEquals(objetivoDeResolucao, new ObjetivoDeResolucao("02:40","02:10"));
        assertNotEquals(objetivoDeResolucao, new ObjetivoDeResolucao("02:40","02:00"));
        assertThrows(IllegalArgumentException.class,() -> new ObjetivoDeResolucao("",""));
        assertThrows(IllegalArgumentException.class,() -> new ObjetivoDeResolucao("25:40","02:10"));
        assertThrows(IllegalArgumentException.class,() -> new ObjetivoDeResolucao("2:61","02:10"));
    }

}