package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FloorTest {
    Floor floor = new Floor("3");

    @Test
    public void test(){
        assertEquals(floor,new Floor("3"));
        assertNotEquals(floor,new Floor("4"));
        assertThrows(IllegalArgumentException.class,() -> new Floor("1000000"));
        assertThrows(IllegalArgumentException.class,() -> new Floor("a"));
        assertThrows(IllegalArgumentException.class,() -> new Floor(""));
        assertThrows(IllegalArgumentException.class,() -> new Floor(null));
    }

}