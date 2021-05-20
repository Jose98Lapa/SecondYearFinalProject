package eapli.base.specifiedTask.domain;

import eapli.base.form.domain.Form;
import eapli.base.specifiedTask.DTO.SpecifiedApprovalTaskDTO;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class SpecifiedApprovalTask extends SpecifiedTask implements DTOable<SpecifiedApprovalTaskDTO> {
    @OneToOne
    private Form form;

    public SpecifiedApprovalTask(TaskID taskID, TaskStatus taskStatus, Form form) {
        super(taskID, taskStatus);
        this.form = form;
    }

    protected SpecifiedApprovalTask() {
        // For ORM
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
    public SpecifiedApprovalTaskDTO toDTO() {
        return new SpecifiedApprovalTaskDTO(super.taskID.toString(),super.taskStatus.toString(),form.toDTO());
    }
}
