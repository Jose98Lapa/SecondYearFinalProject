package eapli.base.formulario.DTO.atributo;

import eapli.base.formulario.Builder.AtributoBuilder;
import eapli.base.formulario.domain.atributo.Atributo;
import eapli.framework.representations.dto.DTOParser;

public class AtributoDTOParser implements DTOParser<AtributoDTO, Atributo> {
    @Override
    public Atributo valueOf(AtributoDTO dto) {
        AtributoBuilder atrb = new AtributoBuilder();
        return atrb.withDesc(dto.desc).withLabel(dto.label).withNome(dto.nome).withRegex(dto.regex).withTipo(dto.tipo).build();
    }
}
