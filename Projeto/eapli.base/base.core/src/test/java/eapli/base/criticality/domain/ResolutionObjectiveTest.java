package eapli.base.criticality.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResolutionObjectiveTest {
    ResolutionObjective resolutionObjective = new ResolutionObjective("02:40","02:10");

    @Test
    public void test(){
        assertEquals(resolutionObjective, new ResolutionObjective("02:40","02:10"));
        assertNotEquals(resolutionObjective, new ResolutionObjective("02:40","02:00"));
        assertThrows(IllegalArgumentException.class,() -> new ResolutionObjective("",""));
        assertThrows(IllegalArgumentException.class,() -> new ResolutionObjective("25:40","02:10"));
        assertThrows(IllegalArgumentException.class,() -> new ResolutionObjective("2:61","02:10"));
    }

}