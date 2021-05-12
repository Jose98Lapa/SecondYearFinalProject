package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    Contact contact = new Contact("921234567");

    @Test
    public void test(){
        assertEquals(contact, new Contact("921234567"));
        assertNotEquals(contact, new Contact("921234565"));
        assertThrows(IllegalArgumentException.class,() -> new Contact("9212345612"));
        assertThrows(IllegalArgumentException.class,() -> new Contact("92123456"));
        assertThrows(IllegalArgumentException.class,() -> new Contact("a"));
        assertThrows(IllegalArgumentException.class,() -> new Contact(""));
        assertThrows(IllegalArgumentException.class,() -> new Contact(null));
    }

}