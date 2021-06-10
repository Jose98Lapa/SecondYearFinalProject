package eapli.base.task.application;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.task.DTO.ExecutionTaskDTO;
import eapli.base.task.domain.Task;
import eapli.base.task.repository.TaskRepository;


import java.util.List;
import java.util.Optional;

public class TaskListService {
    private TaskRepository taskRepository = PersistenceContext.repositories().tasks();



    public Task getTaskByStringList(List<String> tasksIDList){
        Task starterTask = getTaskByID(tasksIDList.get(0));
        Task beforeTask = starterTask;
        for (int i= 1;i<tasksIDList.size();i++){
            Task currentTask = getTaskByID(tasksIDList.get(i));
            currentTask.editBeforeTask(beforeTask);
            beforeTask.editAfterTask(currentTask);
            beforeTask = currentTask;
        }
        return starterTask;

    }

    public Task getTaskByID(String id){
        Optional<Task> optionalTask = taskRepository.ofIdentity(Long.parseLong(id));
        if (optionalTask.isEmpty())
            throw new IllegalArgumentException("Task ID inválido");
        return optionalTask.get();
    }
}
