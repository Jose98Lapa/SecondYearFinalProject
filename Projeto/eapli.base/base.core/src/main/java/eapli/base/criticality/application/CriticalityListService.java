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
        criticidadeRepo.findAllGlobal().forEach(nivel -> niveisCriticidade.add(nivel.toDTO()));
        return niveisCriticidade;
    }


    public long convertCriticalityValueInMinutes(String value){
        String hour = value.substring(0,2);
        String minute = value.substring(3);
        return Long.parseLong(hour)*60 + Long.parseLong(minute);
    }
}
