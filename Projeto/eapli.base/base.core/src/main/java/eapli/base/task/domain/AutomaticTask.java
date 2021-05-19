package eapli.base.task.domain;


import eapli.base.task.DTO.AutomaticTaskDTO;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class AutomaticTask extends Task implements DTOable<AutomaticTaskDTO> {
    @Embedded
    private ScriptPath scriptPath;

    public AutomaticTask(TaskID taskID,TaskStatus taskStatus, ScriptPath scriptPath) {
        super(taskID,taskStatus);
        this.scriptPath = scriptPath;
    }

    protected AutomaticTask() {
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
        AutomaticTask that = (AutomaticTask) o;
        return Objects.equals(scriptPath, that.scriptPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scriptPath);
    }

    @Override
    public AutomaticTaskDTO toDTO() {
        return new AutomaticTaskDTO(super.taskID.toString(),super.taskStatus.toString(),scriptPath.toString());
    }
}
