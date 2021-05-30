package eapli.base.task.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void editBeforeTask() {
        Task starter = new ExecutionTask();
        Task before = new AutomaticTask();
        assertThrows(IllegalArgumentException.class,() ->starter.editBeforeTask(before));
        Task newBefore = new ExecutionTask();
        assertThrows(IllegalArgumentException.class,() ->starter.editBeforeTask(newBefore));
        Task approvalBefore = new ApprovalTask();

       assertAll(() -> starter.editBeforeTask(approvalBefore));
    }


    @Test
    void editAfterTask() {
        Task approval = new ApprovalTask();
        Task newApproval = new ApprovalTask();
        assertThrows(IllegalArgumentException.class,() ->approval.editAfterTask(newApproval));
        Task afterExec = new ExecutionTask();
        assertAll(() -> approval.editAfterTask(afterExec));
        Task afterAuto = new AutomaticTask();
        assertAll(()-> approval.editAfterTask(afterAuto));

    }
}