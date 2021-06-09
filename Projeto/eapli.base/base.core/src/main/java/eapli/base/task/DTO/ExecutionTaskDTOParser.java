package eapli.base.task.DTO;


import eapli.base.form.DTO.FormDTOParser;
import eapli.base.task.domain.ExecutionTask;
import eapli.base.task.domain.TaskID;


import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.DTO.TeamDTOParser;
import eapli.base.team.domain.Team;
import eapli.framework.representations.dto.DTOParser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecutionTaskDTOParser implements DTOParser<ExecutionTaskDTO, ExecutionTask> {
    @Override
    public ExecutionTask valueOf(ExecutionTaskDTO dto) {

        List< Team > teamListDTO =
                dto.teamListDTO
                .stream()
                .map( teamDTO -> new TeamDTOParser().valueOf( teamDTO ) )
                .collect( Collectors.toList() );
        dto.teamListDTO.forEach( x -> teamListDTO.add( new TeamDTOParser().valueOf( x ) ) );

        // jic: dto.teamListDTO.forEach( teamDTO -> teamListDTO.add( new TeamDTOParser().valueOf( teamDTO ) ) );

        return new ExecutionTask(new FormDTOParser().valueOf(dto.formDTO), teamListDTO );
    }
}
