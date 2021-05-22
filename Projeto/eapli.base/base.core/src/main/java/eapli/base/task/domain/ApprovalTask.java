package eapli.base.task.domain;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;
import eapli.base.task.DTO.ApprovalTaskDTO;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class ApprovalTask extends Task implements DTOable<ApprovalTaskDTO> {
    @OneToOne
    private Form form;

    private Date approvalDate;

    @OneToOne
    private Collaborator collaboratorThatApprovedTheTask;

    public ApprovalTask(TaskID taskID,TaskStatus taskStatus, Form form) {
        super(taskID,taskStatus);
        this.form = form;
    }

    protected ApprovalTask() {
        // For ORM
    }

    public void approveTask(Collaborator collaboratorThatApprovedTheTask){
        this.approvalDate = new Date();
        this.collaboratorThatApprovedTheTask = collaboratorThatApprovedTheTask;
    }

    public Form form(){
        return form;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public TaskID identity() {
        return super.taskID;
    }

    @Override
    public ApprovalTaskDTO toDTO() {
        return new ApprovalTaskDTO(super.taskID.toString(),super.taskStatus.toString(),form.toDTO());
    }
}
