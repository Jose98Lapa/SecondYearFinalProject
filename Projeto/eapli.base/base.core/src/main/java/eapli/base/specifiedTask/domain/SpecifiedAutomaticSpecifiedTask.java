package eapli.base.specifiedTask.domain;


import eapli.base.specifiedTask.DTO.SpecifiedAutomaticTaskDTO;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class SpecifiedAutomaticSpecifiedTask extends SpecifiedTask implements DTOable<SpecifiedAutomaticTaskDTO> {
    @Embedded
    private ScriptPath scriptPath;

    public SpecifiedAutomaticSpecifiedTask(TaskID taskID, ScriptPath scriptPath) {
        super(taskID);
        this.scriptPath = scriptPath;
    }

    protected SpecifiedAutomaticSpecifiedTask() {
        // For ORM
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public TaskID identity() {
        return super.taskID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecifiedAutomaticSpecifiedTask that = (SpecifiedAutomaticSpecifiedTask) o;
        return Objects.equals(scriptPath, that.scriptPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scriptPath);
    }

    @Override
    public SpecifiedAutomaticTaskDTO toDTO() {
        return new SpecifiedAutomaticTaskDTO(super.taskID.toString(),scriptPath.toString());
    }
}
