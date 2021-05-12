package eapli.base.colour.Application;

import eapli.base.colour.Builder.ColourBuilder;
import eapli.base.colour.DTO.ColourDTO;
import eapli.base.colour.Domain.Colour;
import eapli.base.colour.reposotories.ColourRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class CreateColourController {
    private final ColourRepository colourRepository = PersistenceContext.repositories().cores();
    private final ColourBuilder colourBuilder = new ColourBuilder();


    public void registo(ColourDTO colourDTO){
        Colour colour = colourBuilder.nome(colourDTO.nome).valorHexadecimal(colourDTO.valorHexadecimal).builder();
        colourRepository.save(colour);
    }



}
