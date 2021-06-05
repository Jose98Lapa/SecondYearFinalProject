package eapli.base.task.domain;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;
import eapli.base.function.domain.Function;
import eapli.base.task.DTO.ApprovalTaskDTO;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ApprovalTask extends ManualTask implements DTOable<ApprovalTaskDTO> , Serializable {

    @OneToOne
    private Function necessaryRoleForApproval;

    public ApprovalTask(Form form,Function necessaryRoleForApproval) {
        super(form);
        this.necessaryRoleForApproval = necessaryRoleForApproval;

    }

    protected ApprovalTask() {
       super();

    }


    public Form form(){
        return super.form();
    }

    @Override
    public ApprovalTaskDTO toDTO() {
        return new ApprovalTaskDTO(super.taskID.toString(),super.form().toDTO());
    }
}
