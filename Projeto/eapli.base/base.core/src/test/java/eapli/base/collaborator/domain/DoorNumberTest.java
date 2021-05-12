package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoorNumberTest {
    DoorNumber doorNumber = new DoorNumber("2");

    @Test
    public void teste(){
        assertEquals(doorNumber,new DoorNumber("2"));
        assertNotEquals(doorNumber,new DoorNumber("20"));
        assertThrows(IllegalArgumentException.class,() -> new DoorNumber("2000000"));
        assertThrows(IllegalArgumentException.class,() -> new DoorNumber("a"));
        assertThrows(IllegalArgumentException.class,() -> new DoorNumber(""));
        assertThrows(IllegalArgumentException.class,() -> new DoorNumber(null));
    }

}