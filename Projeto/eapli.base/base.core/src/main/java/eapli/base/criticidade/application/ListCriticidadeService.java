package eapli.base.criticidade.application;

import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.base.criticidade.repository.CriticidadeRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Set;

public class ListCriticidadeService {

    private final CriticidadeRepository criticidadeRepo = PersistenceContext.repositories().criticidade();

    public Iterable<CriticidadeDTO> criticidades(){
        Set<CriticidadeDTO>  niveisCriticidade = new HashSet<>();
        criticidadeRepo.findAll().forEach(nivel -> niveisCriticidade.add(nivel.toDTO()));
        return niveisCriticidade;
    }
}
