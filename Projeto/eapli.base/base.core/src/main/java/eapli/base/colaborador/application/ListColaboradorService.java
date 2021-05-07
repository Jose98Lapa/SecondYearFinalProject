package eapli.base.colaborador.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Set;

public class ListColaboradorService {
    private final EquipaRepository teamRepo = PersistenceContext.repositories().teams();

    public Iterable<Colaborador> teams(){
        //Set<EquipaDTO> equipas = new HashSet<>();
        //teamRepo.findAll().forEach(equipa -> equipas.add(equipa.toDTO()));
        //return equipas;
        return null;
    }
}
