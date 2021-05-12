package eapli.base.form.DTO.attribute;

import eapli.base.form.Builder.AttributeBuilder;
import eapli.base.form.domain.attribute.Attribute;
import eapli.framework.representations.dto.DTOParser;

public class AttributeDTOParser implements DTOParser<AttributeDTO, Attribute> {
    @Override
    public Attribute valueOf(AttributeDTO dto) {
        AttributeBuilder atrb = new AttributeBuilder();
        return atrb.withDesc(dto.desc).withLabel(dto.label).withNome(dto.nome).withRegex(dto.regex).withTipo(dto.tipo).withId(dto.id).build();
    }
}
