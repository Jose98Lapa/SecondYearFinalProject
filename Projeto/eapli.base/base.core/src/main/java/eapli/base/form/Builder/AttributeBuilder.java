package eapli.base.form.Builder;

import eapli.base.form.domain.attribute.*;

public class AttributeBuilder {
    private AtributteName nome;
    private AttributeLabel label;
    private AttributeDescription desc;
    private AttributeRegex regex;
    private AttributeType tipo;
    private AttributeID id;

    public Attribute build(){
        return new Attribute(nome,label,desc,regex,tipo,id);
    }

    public AttributeBuilder withNome(String nome) {
        this.nome = AtributteName.valueOf(nome);
        return this;
    }

    public AttributeBuilder withLabel(String label) {
        this.label = AttributeLabel.valueOf(label);
        return this;
    }

    public AttributeBuilder withDesc(String desc) {
        this.desc = AttributeDescription.valueOf(desc);
        return this;
    }

    public AttributeBuilder withRegex(String regex) {
        this.regex = AttributeRegex.valueOf(regex);
        return this;
    }

    public AttributeBuilder withTipo(String tipo) {
        this.tipo = AttributeType.valueOf(tipo);
        return this;
    }
    public AttributeBuilder withId(String id) {
        this.id = AttributeID.valueOf(id);
        return this;
    }
}
