package eapli.base.collaborator.application;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.team.domain.Team;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Set;

public class ListCollaboratorService {
    private final CollaboratorRepository colaboratorRepo = PersistenceContext.repositories().collaborators();

    public Iterable<CollaboratorDTO> colaboradores(){
        Set<CollaboratorDTO>  colaboradores = new HashSet<>();
        colaboratorRepo.findAll().forEach(colaborador -> colaboradores.add(colaborador.toDTO()));
        return colaboradores;
    }

    public Set<CollaboratorDTO> getColadorDumEquipas(Team team){
        Set<CollaboratorDTO> collaboratorDTOS = new HashSet<>();
        for (Collaborator collaborator : colaboratorRepo.findAll()){
            if (team.containsTeamMember(collaborator)){
                collaboratorDTOS.add(collaborator.toDTO());
            }
        }
        return collaboratorDTOS;

    }
}
