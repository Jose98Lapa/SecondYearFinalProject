package eapli.base.equipa.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Set;

public class ListEquipaService {
    private final EquipaRepository teamRepo = PersistenceContext.repositories().teams();

    public Iterable<EquipaDTO> allTeams(){
        Set<EquipaDTO> equipas = new HashSet<>();
        teamRepo.findAll().forEach(equipa -> equipas.add(equipa.toDTO()));
        return equipas;
    }

    public Set<EquipaDTO> getEquipasDumColaborador(Colaborador colaborador){
        Set<EquipaDTO> equipaDTOS = new HashSet<>();
        for (Equipa equipa: teamRepo.findAll()){
            if (equipa.containsTeamMember(colaborador)){
                equipaDTOS.add(equipa.toDTO());
            }
        }
        return equipaDTOS;
    }
}
