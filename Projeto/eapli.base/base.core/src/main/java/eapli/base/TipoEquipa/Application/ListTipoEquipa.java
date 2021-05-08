package eapli.base.TipoEquipa.Application;

import eapli.base.TipoEquipa.DTO.TipoEquipaDTO;

import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.TipoEquipa.repository.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class ListTipoEquipa {
    private TipoEquipaRepository tipoEquipaRepository = PersistenceContext.repositories().tiposDeEquipa();

    public Iterable<TipoEquipaDTO> tipoEquipaDTOS(){
        List<TipoEquipaDTO> tempListTipoEquipaID = new ArrayList<>(20);
        for (TipoEquipa tipoEquipa:tipoEquipaRepository.findAll()){
            tempListTipoEquipaID.add(tipoEquipa.toDTO());
        }
        return tempListTipoEquipaID;
    }
}
