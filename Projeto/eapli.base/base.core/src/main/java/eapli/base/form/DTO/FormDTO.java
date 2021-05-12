package eapli.base.form.DTO;

import eapli.base.form.DTO.attribute.AttributeDTO;

import java.util.Set;

public class FormDTO {
    public String script;
    public String id;
    public String nome;
    public Set<AttributeDTO> atrDTO;

    public FormDTO(String script, String id, String nome, Set<AttributeDTO> atr) {
        this.script= script;
        this.id= id;
        this.nome= nome;
        this.atrDTO = atr;
    }

}