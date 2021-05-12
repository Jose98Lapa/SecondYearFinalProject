package eapli.base.criticality.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValorCriticalityTest {
    CriticalityValue criticalityValue = new CriticalityValue("1");

    @Test
    public void test(){
        assertEquals(criticalityValue, new CriticalityValue("1"));
        assertNotEquals(criticalityValue, new CriticalityValue("2"));
        assertThrows(IllegalArgumentException.class,() -> new CriticalityValue("a"));
        assertThrows(IllegalArgumentException.class,() -> new CriticalityValue(""));
        assertThrows(IllegalArgumentException.class,() -> new CriticalityValue(null));
    }
}