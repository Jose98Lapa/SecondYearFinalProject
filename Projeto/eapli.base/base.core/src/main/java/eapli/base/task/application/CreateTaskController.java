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
import eapli.base.team.domain.Team;

import java.util.ArrayList;
import java.util.List;

public class CreateTaskController {

    FunctionService functionService = new FunctionService();
    TeamListService teamListService = new TeamListService();
    public String registerApprovalTask(ApprovalTaskDTO approvalTaskDTO){
        TaskRepository taskRepository = PersistenceContext.repositories().tasks();

        Task task = new ApprovalTask(getForm(approvalTaskDTO.formID),functionService.getFunctionByID(approvalTaskDTO.functionDTO.idFunction));
        taskRepository.save(task);
        return task.identity().toString();
    }

    public String registerManualTask(ExecutionTaskDTO executionTaskDTO){
        TaskRepository taskRepository = PersistenceContext.repositories().tasks();

        List< Team > teamList = new ArrayList<>( );

        executionTaskDTO
                .teamListDTO
                .forEach( teamDTO -> teamList.add( teamListService.getTeam( teamDTO.teamID ) ) );

        Task task = new ExecutionTask(getForm(executionTaskDTO.formID),teamList );
        taskRepository.save(task);

        return task.identity().toString();
    }

    public String registerAutomaticTask(AutomaticTaskDTO approvalTaskDTO){
        TaskRepository taskRepository = PersistenceContext.repositories().tasks();
        Task task = new AutomaticTask(ScriptPath.valueOf(approvalTaskDTO.script));
        taskRepository.save(task);
        return task.identity().toString();
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
