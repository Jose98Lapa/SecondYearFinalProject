package eapli.base.teamType.Application;

import eapli.base.teamType.DTO.TeamTypeDTO;

import eapli.base.teamType.Domain.TeamType;
import eapli.base.teamType.repository.TeamTypeRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class TeamTypeListService {
    private TeamTypeRepository teamTypeRepository = PersistenceContext.repositories().tiposDeEquipa();

    public Iterable<TeamTypeDTO> tipoEquipaDTOS(){
        List<TeamTypeDTO> tempListTipoEquipaID = new ArrayList<>(20);
        for (TeamType teamType : teamTypeRepository.findAll()){
            tempListTipoEquipaID.add(teamType.toDTO());
        }
        return tempListTipoEquipaID;
    }
}
