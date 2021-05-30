package eapli.base.task.domain;

import eapli.base.team.domain.TeamID;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskIDTest {
    TaskID taskIDtest = new TaskID("123");
    @Test
    public void test() {
        assertEquals(taskIDtest, new TaskID("123"));
        assertEquals(taskIDtest,TaskID.valueOf("123"));
        assertNotEquals(taskIDtest, new TeamID("12"));
        assertThrows(IllegalArgumentException.class,() -> new TeamID("a"));
        assertThrows(IllegalArgumentException.class,() -> new TeamID(""));
        assertThrows(IllegalArgumentException.class,() -> new TeamID(null));
    }
}