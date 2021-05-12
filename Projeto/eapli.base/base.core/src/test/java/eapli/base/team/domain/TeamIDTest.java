package eapli.base.team.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamIDTest {
    TeamID acronimo = new TeamID("123");

    @Test
    public void test() {
        assertEquals(acronimo, new TeamID("123"));
        assertNotEquals(acronimo, new TeamID("12"));
        assertThrows(IllegalArgumentException.class,() -> new TeamID("a"));
        assertThrows(IllegalArgumentException.class,() -> new TeamID(""));
        assertThrows(IllegalArgumentException.class,() -> new TeamID(null));
    }

}