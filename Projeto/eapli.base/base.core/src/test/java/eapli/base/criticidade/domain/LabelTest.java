package eapli.base.criticidade.domain;

import eapli.base.colaborador.domain.Alcunha;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LabelTest {
    Label label = new Label("Label da Criticidade");

    @Test
    public void test(){
        assertEquals(label, new Label("Label da Criticidade"));
        assertNotEquals(label, new Label("Nao e Label da Criticidade"));
        assertThrows(IllegalArgumentException.class,() -> new Label(""));
        assertThrows(IllegalArgumentException.class,() -> new Label(null));
    }
}