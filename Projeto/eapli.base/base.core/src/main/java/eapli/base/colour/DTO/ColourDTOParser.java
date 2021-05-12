package eapli.base.colour.DTO;

import eapli.base.colour.Builder.ColourBuilder;
import eapli.base.colour.Domain.Colour;
import eapli.framework.representations.dto.DTOParser;

public class ColourDTOParser implements DTOParser<ColourDTO, Colour> {
    @Override
    public Colour valueOf(ColourDTO dto) {
        ColourBuilder colourBuilder = new ColourBuilder();
        colourBuilder.nome(dto.nome).valorHexadecimal(dto.valorHexadecimal);
        return colourBuilder.builder();
    }
}
