package eapli.base.task.repository;

import eapli.base.service.domain.Service;
import eapli.base.task.domain.Task;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Set;

public interface TaskRepository extends DomainRepository<Long, Task> {

	List< Task > serviceTasks ( Service service );
}
