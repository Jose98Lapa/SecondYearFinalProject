package eapli.base.formulario.DTO.atributo;

import eapli.base.formulario.domain.atributo.*;

public class AtributoDTO {
    public String nome;
    public String label;
    public String desc;
    public String regex;
    public String tipo;
    public String id;

    public AtributoDTO(String nome, String label, String desc, String regex, String tipo,String id) {
        this.nome = nome;
        this.label = label;
        this.desc = desc;
        this.regex = regex;
        this.tipo = tipo;
        this.id = id;
    }
}
