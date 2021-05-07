package eapli.base.criticidade.repository;

import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Set;

public class ListCriticidadeService {
    private final CriticidadeRepository criticidadesRepo = PersistenceContext.repositories().criticidades();

    public Iterable<CriticidadeDTO> criticidades(){
        Set<CriticidadeDTO>  niveisCriticidade = new HashSet<>();
        criticidadesRepo.findAll().forEach(nivel -> niveisCriticidade.add(nivel.toDTO()));
        return niveisCriticidade;
    }
}
