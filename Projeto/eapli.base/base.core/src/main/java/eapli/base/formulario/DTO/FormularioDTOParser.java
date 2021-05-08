package eapli.base.formulario.DTO;

import eapli.base.formulario.DTO.atributo.AtributoDTO;
import eapli.base.formulario.Builder.FormularioBuilder;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.atributo.*;
import eapli.framework.representations.dto.DTOParser;

import java.util.HashSet;
import java.util.Set;

public class FormularioDTOParser implements DTOParser<FormularioDTO, Formulario> {
    @Override
    public Formulario valueOf(FormularioDTO dto) {
        FormularioBuilder svb = new FormularioBuilder();
        Set<Atributo> atr = new HashSet<>();
        for (AtributoDTO atributo:dto.atrDTO) {
            atr.add(new Atributo(AtributoNome.valueOf(atributo.nome), AtributoLabel.valueOf(atributo.label), AtributoDescricao.valueOf(atributo.desc), AtributoRegex.valueOf(atributo.regex),AtributoTipo.valueOf(atributo.tipo),AtributoID.valueOf(atributo.id)));
        }
        return svb.setAtr(atr).setId(dto.id).setNome(dto.nome).setScript(dto.script).build();
    }
}
