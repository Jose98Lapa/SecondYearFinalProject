package eapli.base.cor.Application;

import eapli.base.cor.DTO.CorDTO;
import eapli.base.cor.Domain.Cor;
import eapli.base.cor.reposotories.CorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class ListCores {
    private final CorRepository corRepository = PersistenceContext.repositories().cores();
    public Iterable<CorDTO> corDTOIterable(){
        List<CorDTO> list = new ArrayList<>(20);
        for (Cor cor:corRepository.findAll()){
            list.add(cor.toDTO());
        }
        return list;

    }

}
