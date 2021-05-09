package eapli.base.colaborador.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Set;

public class ListColaboradorService {
    private final CollaboratorRepository colaboratorRepo = PersistenceContext.repositories().collaborators();

    public Iterable<ColaboradorDTO> colaboradores(){
        Set<ColaboradorDTO>  colaboradores = new HashSet<>();
        colaboratorRepo.findAll().forEach(colaborador -> colaboradores.add(colaborador.toDTO()));
        return colaboradores;
    }

    public Set<ColaboradorDTO> getColadorDumEquipas(Equipa equipa){
        Set<ColaboradorDTO> colaboradorDTOS = new HashSet<>();
        for (Colaborador colaborador : colaboratorRepo.findAll()){
            if (equipa.containsTeamMember(colaborador)){
                colaboradorDTOS.add(colaborador.toDTO());
            }
        }
        return colaboradorDTOS;

    }
}
