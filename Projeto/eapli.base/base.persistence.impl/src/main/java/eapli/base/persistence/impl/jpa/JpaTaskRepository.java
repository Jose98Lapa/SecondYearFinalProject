package eapli.base.persistence.impl.jpa;

import eapli.base.task.domain.Task;
import eapli.base.task.domain.TaskID;
import eapli.base.task.repository.TaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaTaskRepository extends JpaAutoTxRepository<Task,TaskID, TaskID> implements TaskRepository {
    public JpaTaskRepository(TransactionalContext tx) {
        super(tx, "Task");
    }
    public JpaTaskRepository(String persistenceUnitName){
        super(persistenceUnitName,"Task");
    }
}
