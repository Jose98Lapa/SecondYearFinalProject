package eapli.base.equipa.application;

import eapli.base.equipa.DTO.EquipaDTO;
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
}
