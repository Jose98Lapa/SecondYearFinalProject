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

    public AtributoBuilder withLabel(String label) {
        this.label = AtributoLabel.valueOf(label);
        return this;
    }

    public AtributoBuilder withDesc(String desc) {
        this.desc = AtributoDescricao.valueOf(desc);
        return this;
    }

    public AtributoBuilder withRegex(String regex) {
        this.regex = AtributoRegex.valueOf(regex);
        return this;
    }

    public AtributoBuilder withTipo(String tipo) {
        this.tipo = AtributoTipo.valueOf(tipo);
        return this;
    }
}
