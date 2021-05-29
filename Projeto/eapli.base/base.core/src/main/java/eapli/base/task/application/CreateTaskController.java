package eapli.base.task.application;

import eapli.base.form.application.FormService;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.function.DTO.FunctionDTO;
import eapli.base.function.application.FunctionService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.task.DTO.ApprovalTaskDTO;
import eapli.base.task.DTO.AutomaticTaskDTO;
import eapli.base.task.DTO.ExecutionTaskDTO;
import eapli.base.task.domain.*;
import eapli.base.task.repository.TaskRepository;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.application.TeamListService;

import java.util.List;

public class CreateTaskController {

    FunctionService functionService = new FunctionService();
    TeamListService teamListService = new TeamListService();
    public void registerApprovalTask(ApprovalTaskDTO approvalTaskDTO){
        TaskRepository taskRepository = PersistenceContext.repositories().tasks();

        Task task = new ApprovalTask(TaskID.valueOf(approvalTaskDTO.taskID),getForm(approvalTaskDTO.formID),functionService.getFunctionByID(approvalTaskDTO.functionDTO.idFunction));
        taskRepository.save(task);
    }

    public void registerManualTask(ExecutionTaskDTO approvalTaskDTO){
        TaskRepository taskRepository = PersistenceContext.repositories().tasks();

        Task task = new ExecutionTask(TaskID.valueOf(approvalTaskDTO.taskID),getForm(approvalTaskDTO.formID),teamListService.getTeam(approvalTaskDTO.teamDTO.teamID));
        taskRepository.save(task);
    }

    public void registerAutomaticTask(AutomaticTaskDTO approvalTaskDTO){
        TaskRepository taskRepository = PersistenceContext.repositories().tasks();
        Task task = new AutomaticTask(TaskID.valueOf(approvalTaskDTO.taskID),ScriptPath.valueOf(approvalTaskDTO.script));
        taskRepository.save(task);
    }

    private Form getForm(String formId){
        FormService formService = new FormService();
        return formService.getFormFromID(FormID.valueOf(formId));
    }

    public List<FunctionDTO> getFunctionsDTO(){
        return functionService.getFunctionDTOList();
    }

    public Iterable<TeamDTO> getTeamDTO(){
        return teamListService.allTeams();
    }
}
