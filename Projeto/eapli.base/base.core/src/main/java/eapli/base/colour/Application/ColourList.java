package eapli.base.colour.Application;

import eapli.base.colour.DTO.ColourDTO;
import eapli.base.colour.Domain.Colour;
import eapli.base.colour.reposotories.ColourRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class ColourList {
    private final ColourRepository colourRepository = PersistenceContext.repositories().cores();
    public Iterable<ColourDTO> corDTOIterable(){
        List<ColourDTO> list = new ArrayList<>(20);
        for (Colour colour : colourRepository.findAll()){
            list.add(colour.toDTO());
        }
        return list;

    }

}
