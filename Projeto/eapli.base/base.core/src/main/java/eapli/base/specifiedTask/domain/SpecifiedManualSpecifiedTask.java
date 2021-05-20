package eapli.base.specifiedTask.domain;


import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;
import eapli.base.specifiedTask.DTO.SpecifiedManualTaskDTO;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.OneToOne;

public class SpecifiedManualSpecifiedTask extends SpecifiedTask implements DTOable<SpecifiedManualTaskDTO> {

    @OneToOne
    private Form form;


    public SpecifiedManualSpecifiedTask(TaskID taskID, TaskStatus taskStatus, Form form){
        super(taskID,taskStatus);
        this.form = form;
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
    public SpecifiedManualTaskDTO toDTO() {
        return new SpecifiedManualTaskDTO(super.taskID.toString(),super.taskStatus.toString(), form().toDTO());
    }
}
