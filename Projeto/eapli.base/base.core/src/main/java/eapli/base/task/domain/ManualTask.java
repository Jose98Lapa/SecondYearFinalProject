package eapli.base.task.domain;


import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.form.domain.Form;
import eapli.base.task.DTO.ManualTaskDTO;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

public class ManualTask extends Task implements DTOable<ManualTaskDTO> {

    @OneToOne
    private Form form;

    @OneToMany
    private Set<Collaborator> interveningCollaborators;


    public ManualTask(TaskID taskID,TaskStatus taskStatus, Form form){
        super(taskID,taskStatus);
        this.form = form;
    }



    public Form form(){
        return form;
    }

    public void addAnInterveningCollaborator(Collaborator interveningCollaborator){
        this.interveningCollaborators.add(interveningCollaborator);
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
        Set<CollaboratorDTO> interveningCollaboratorsDTO = new HashSet<>();
        for (Collaborator collaborator:interveningCollaborators){
            interveningCollaboratorsDTO.add(collaborator.toDTO());
        }

        return new ManualTaskDTO(super.taskID.toString(),super.taskStatus.toString(), form().toDTO(),interveningCollaboratorsDTO);
    }
}
