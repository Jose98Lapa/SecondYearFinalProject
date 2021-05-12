package eapli.base.teamType.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoTeamIDTest {
    TeamTypeID teamTypeID = new TeamTypeID("T12");

    @Test
    public void test(){
        assertEquals(teamTypeID, new TeamTypeID("T12"));
        assertNotEquals(teamTypeID, new TeamTypeID("T13"));
        assertThrows(IllegalArgumentException.class,() -> new TeamTypeID("IDGRANDE"));
        assertThrows(IllegalArgumentException.class,() -> new TeamTypeID(""));
        assertThrows(IllegalArgumentException.class,() -> new TeamTypeID(null));
    }
}