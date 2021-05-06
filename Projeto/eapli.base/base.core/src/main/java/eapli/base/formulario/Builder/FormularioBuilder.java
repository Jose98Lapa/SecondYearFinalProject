package eapli.base.formulario.Builder;

import eapli.base.atributo.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.FormularioID;
import eapli.base.formulario.domain.FormularioNome;
import eapli.base.formulario.domain.FormularioScript;

import java.util.Set;

public class FormularioBuilder {
    private FormularioScript script;
    private FormularioID id;
    private FormularioNome nome;
    private Set<Atributo> atr;

    public Formulario build(){
        return  new Formulario(script, id, nome,atr);
    }

    public FormularioBuilder setScript(String script) {
        this.script = FormularioScript.valueOf(script);
        return this;
    }

    public FormularioBuilder setId(String id) {
        this.id = FormularioID.valueOf(id);
        return this;
    }

    public FormularioBuilder setNome(String nome) {
        this.nome = FormularioNome.valueOf(nome);
        return this;
    }

    public FormularioBuilder setAtr(Set<Atributo> atr) {
        this.atr = atr;
        return this;
    }
}
