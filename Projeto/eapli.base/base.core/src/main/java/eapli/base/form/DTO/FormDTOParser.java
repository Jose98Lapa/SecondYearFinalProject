package eapli.base.form.DTO;

import eapli.base.form.DTO.attribute.AttributeDTO;
import eapli.base.form.Builder.FormBuilder;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.attribute.*;
import eapli.framework.representations.dto.DTOParser;

import java.util.HashSet;
import java.util.Set;

public class FormDTOParser implements DTOParser<FormDTO, Form> {
    @Override
    public Form valueOf(FormDTO dto) {
        FormBuilder svb = new FormBuilder();
        Set<Attribute> atr = new HashSet<>();
        for (AttributeDTO atributo:dto.atrDTO) {
            atr.add(new Attribute(AtributteName.valueOf(atributo.nome), AttributeLabel.valueOf(atributo.label), AttributeDescription.valueOf(atributo.desc), AttributeRegex.valueOf(atributo.regex), AttributeType.valueOf(atributo.tipo), AttributeID.valueOf(atributo.id)));
        }
        return svb.setAtr(atr).setId(dto.id).setNome(dto.nome).setScript(dto.script).build();
    }
}
