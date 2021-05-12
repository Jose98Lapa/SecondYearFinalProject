package eapli.base.form.Builder;

import eapli.base.form.domain.attribute.Attribute;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.domain.FormName;
import eapli.base.form.domain.FormScript;

import java.util.Set;

public class FormBuilder {
    private FormScript script;
    private FormID id;
    private FormName nome;
    private Set<Attribute> atr;

    public Form build(){
        return  new Form(script, id, nome,atr);
    }

    public FormBuilder setScript(String script) {
        this.script = FormScript.valueOf(script);
        return this;
    }

    public FormBuilder setId(String id) {
        this.id = FormID.valueOf(id);
        return this;
    }

    public FormBuilder setNome(String nome) {
        this.nome = FormName.valueOf(nome);
        return this;
    }

    public FormBuilder setAtr(Set<Attribute> atr) {
        this.atr = atr;
        return this;
    }
}
