package eapli.base.atributo.builder;

import eapli.base.atributo.domain.*;

public class AtributoBuilder {
    private AtributoNome nome;
    private AtributoLabel label;
    private AtributoDescricao desc;
    private AtributoRegex regex;
    private AtributoTipo tipo;

    public Atributo build(){
        return new Atributo(nome,label,desc,regex,tipo);
    }

    public AtributoBuilder withNome(String nome) {
        this.nome = AtributoNome.valueOf(nome);
        return this;
    }

    public AtributoBuilder withLabel(AtributoLabel label) {
        this.label = label;
        return this;
    }

    public AtributoBuilder withDesc(AtributoDescricao desc) {
        this.desc = desc;
        return this;
    }

    public AtributoBuilder withRegex(AtributoRegex regex) {
        this.regex = regex;
        return this;
    }

    public AtributoBuilder withTipo(AtributoTipo tipo) {
        this.tipo = tipo;
        return this;
    }
}
