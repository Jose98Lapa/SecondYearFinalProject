package eapli.base.criticality.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LabelTest {
    Label label = new Label("Label da Criticidade");

    @Test
    public void test(){
        assertEquals(label, new Label("Label da Criticidade"));
        assertNotEquals(label, new Label("Nao e Label da Criticidade"));
        assertThrows(IllegalArgumentException.class,() -> new Label("Um label não pode ser longo demais pois a um certo tamanhao dei" +
                "xa de ser intuitivo"));
        assertThrows(IllegalArgumentException.class,() -> new Label(""));
        assertThrows(IllegalArgumentException.class,() -> new Label(null));
    }
}