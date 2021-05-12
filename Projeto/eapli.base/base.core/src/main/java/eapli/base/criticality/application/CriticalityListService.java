package eapli.base.criticality.application;

import eapli.base.criticality.dto.CriticalityDTO;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Set;

public class CriticalityListService {

    private final CriticalityRepository criticidadeRepo = PersistenceContext.repositories().criticidade();

    public Iterable<CriticalityDTO> criticidades(){
        Set<CriticalityDTO>  niveisCriticidade = new HashSet<>();
        criticidadeRepo.findAll().forEach(nivel -> niveisCriticidade.add(nivel.toDTO()));
        return niveisCriticidade;
    }
}
