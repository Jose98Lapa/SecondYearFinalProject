package eapli.base.TipoEquipa.Application;

import eapli.base.TipoEquipa.Builder.TipoEquipaBuilder;
import eapli.base.TipoEquipa.DTO.TipoEquipaDTO;
import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.TipoEquipa.repository.TipoEquipaRepository;
import eapli.base.cor.Application.ListCores;
import eapli.base.cor.DTO.CorDTO;
import eapli.base.cor.Domain.Cor;
import eapli.base.cor.Domain.Hexadecimal;
import eapli.base.cor.reposotories.CorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Optional;

public class CriarTipoEquipaController {
    private final TipoEquipaRepository tipoEquipaRepository = PersistenceContext.repositories().tiposDeEquipa();
    private final TipoEquipaBuilder tipoEquipaBuilder = new TipoEquipaBuilder();
    private final ListCores coresList = new ListCores();
    private final CorRepository corRepository = PersistenceContext.repositories().cores();

    public void registo(TipoEquipaDTO tipoEquipaDTO){
        Optional<Cor> corOptional = corRepository.ofIdentity(Hexadecimal.valueOf(tipoEquipaDTO.corDTO.valorHexadecimal));
        if (corOptional.isPresent()){
            TipoEquipa tipoEquipa = tipoEquipaBuilder.tipoEquipaID(tipoEquipaDTO.code).descricao(tipoEquipaDTO.descricao).cor(corOptional.get()).build();
            tipoEquipaRepository.save(tipoEquipa);
        }

    }

    public Iterable<CorDTO> getCores(){
        return coresList.corDTOIterable();
    }


}
