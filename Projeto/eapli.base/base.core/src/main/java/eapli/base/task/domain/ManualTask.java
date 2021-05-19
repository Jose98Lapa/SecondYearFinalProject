package eapli.base.task.domain;


import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;
import eapli.base.task.DTO.ManualTaskDTO;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.OneToOne;

public class ManualTask extends Task implements DTOable<ManualTaskDTO> {

    @OneToOne
    private Form form;

    @OneToOne
    private Collaborator collaborator;

    public ManualTask(TaskID taskID,TaskStatus taskStatus,Form form){
        super(taskID,taskStatus);
        this.form = form;
    }

    public void addCollaborator(Collaborator collaborator){
        this.collaborator = collaborator;
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
    public ManualTaskDTO toDTO() {
        return new ManualTaskDTO(super.taskID.toString(),super.taskStatus.toString(), form().toDTO());
    }
}
