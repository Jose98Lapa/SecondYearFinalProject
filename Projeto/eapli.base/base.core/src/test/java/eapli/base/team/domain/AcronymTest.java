package eapli.base.team.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AcronymTest {
    Acronym acronym = new Acronym("RTP");

    @Test
    public void test() {
        assertEquals(acronym, new Acronym("RTP"));
        assertNotEquals(acronym, new Acronym("RTP12"));
        assertThrows(IllegalArgumentException.class,() -> new Acronym("a"));
        assertThrows(IllegalArgumentException.class,() -> new Acronym(""));
        assertThrows(IllegalArgumentException.class,() -> new Acronym(null));
    }

}