package eapli.base.formulario.Builder;

import eapli.base.formulario.domain.atributo.*;

public class AtributoBuilder {
    private AtributoNome nome;
    private AtributoLabel label;
    private AtributoDescricao desc;
    private AtributoRegex regex;
    private AtributoTipo tipo;
    private AtributoID id;

    public Atributo build(){
        return new Atributo(nome,label,desc,regex,tipo,id);
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
    public AtributoBuilder withId(String id) {
        this.id = AtributoID.valueOf(id);
        return this;
    }
}
