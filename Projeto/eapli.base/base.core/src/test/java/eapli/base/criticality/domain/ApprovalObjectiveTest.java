package eapli.base.criticality.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApprovalObjectiveTest {
    ApprovalObjective approvalObjective = new ApprovalObjective("02:40","02:10");

    @Test
    public void test(){
        assertEquals(approvalObjective, new ApprovalObjective("02:40","02:10"));
        assertNotEquals(approvalObjective, new ApprovalObjective("02:40","02:00"));
        assertThrows(IllegalArgumentException.class,() -> new ApprovalObjective("",""));
        assertThrows(IllegalArgumentException.class,() -> new ResolutionObjective("25:40","02:10"));
        assertThrows(IllegalArgumentException.class,() -> new ResolutionObjective("2:61","02:10"));
    }

}