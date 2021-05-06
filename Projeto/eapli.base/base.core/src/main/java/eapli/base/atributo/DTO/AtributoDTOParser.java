package eapli.base.atributo.DTO;

import eapli.base.atributo.builder.AtributoBuilder;
import eapli.base.atributo.domain.Atributo;
import eapli.framework.representations.dto.DTOParser;

public class AtributoDTOParser implements DTOParser<AtributoDTO, Atributo> {
    @Override
    public Atributo valueOf(AtributoDTO dto) {
        AtributoBuilder atrb = new AtributoBuilder();
        return atrb.withDesc(dto.desc).withLabel(dto.label).withNome(dto.nome).withRegex(dto.regex).withTipo(dto.tipo).build();
    }
}
