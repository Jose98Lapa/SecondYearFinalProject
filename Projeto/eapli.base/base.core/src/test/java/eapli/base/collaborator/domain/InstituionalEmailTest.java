package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InstituionalEmailTest {

    InstituionalEmail email = new InstituionalEmail("tomy@gmail.com");

    @Test
    public void test(){
        assertEquals(email, new InstituionalEmail("tomy@gmail.com"));
        assertNotEquals(email, new InstituionalEmail("tiago@gmail.com"));
        assertThrows(IllegalArgumentException.class,() -> new InstituionalEmail("tiago@gmail"));
        assertThrows(IllegalArgumentException.class,() -> new InstituionalEmail("a"));
        assertThrows(IllegalArgumentException.class,() -> new InstituionalEmail(""));
        assertThrows(IllegalArgumentException.class,() -> new InstituionalEmail(null));
    }
}