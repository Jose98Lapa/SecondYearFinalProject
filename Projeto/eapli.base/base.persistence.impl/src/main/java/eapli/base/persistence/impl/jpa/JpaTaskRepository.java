package eapli.base.persistence.impl.jpa;


import eapli.base.service.domain.Service;
import eapli.base.task.domain.Task;
import eapli.base.task.repository.TaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaTaskRepository extends JpaAutoTxRepository<Task,Long, Long> implements TaskRepository {
    public JpaTaskRepository(TransactionalContext tx) {
        super(tx, "Task");
    }
    public JpaTaskRepository(String persistenceUnitName){
        super(persistenceUnitName,"Task");
    }

    @Override
    public Optional<Task> ofIdentity(Long id) {
        final TypedQuery<Task> query =
                createQuery("Select e From eapli.base.task.domain.Task e where e.taskID =: id ",
                        Task.class);
        query.setParameter(  "id", id );
        return query.getResultStream().findFirst();
    }

    @Override
    public List< Task > serviceTasks ( Service service ) {
        //TODO: Complete query
        final TypedQuery< Task > query = createQuery(
                "Select task From eapli.base.task.domain.Task task where task.", Task.class
        );

        query.setParameter( "id", service.identity() );
        return query.getResultList();
    }

}
