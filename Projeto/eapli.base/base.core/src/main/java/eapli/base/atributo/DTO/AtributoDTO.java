package eapli.base.atributo.DTO;

import eapli.base.atributo.domain.*;

public class AtributoDTO {
    public String nome;
    public String label;
    public String desc;
    public String regex;
    public String tipo;

    public AtributoDTO(AtributoNome nome, AtributoLabel label, AtributoDescricao desc, AtributoRegex regex, AtributoTipo tipo) {
        this.nome = nome.toString();
        this.label = label.toString();
        this.desc = desc.toString();
        this.regex = regex.toString();
        this.tipo = tipo.toString();
    }
}
