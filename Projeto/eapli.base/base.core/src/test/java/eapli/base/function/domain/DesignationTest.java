package eapli.base.function.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesignationTest {
    Designation desig = new Designation("lavar janelas");

    @Test
    public void test(){
        assertEquals(desig,  new Designation("lavar janelas"));
        assertNotEquals(desig,  new Designation("lavar portas"));
        assertThrows(IllegalArgumentException.class,() -> new Designation(""));
        assertThrows(IllegalArgumentException.class,() -> new Designation(null));
    }

}