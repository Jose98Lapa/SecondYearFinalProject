package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZipCodeTest {
    ZipCode zipCode = new ZipCode("4953-123");

    @Test
    public void test(){
        assertEquals(zipCode,new ZipCode("4953-123"));
        assertNotEquals(zipCode,new ZipCode("3212-123"));
        assertThrows(IllegalArgumentException.class,() -> new ZipCode("4324-23"));
        assertThrows(IllegalArgumentException.class,() -> new ZipCode("a"));
        assertThrows(IllegalArgumentException.class,() -> new ZipCode(""));
        assertThrows(IllegalArgumentException.class,() -> new ZipCode(null));
    }

}