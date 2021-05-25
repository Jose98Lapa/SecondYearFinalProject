package eapli.base.task.repository;

import eapli.base.task.domain.Task;
import eapli.base.task.domain.TaskID;
import eapli.framework.domain.repositories.DomainRepository;

public interface TaskRepository extends DomainRepository<TaskID, Task> {
}
