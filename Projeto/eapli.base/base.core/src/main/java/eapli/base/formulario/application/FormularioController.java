package eapli.base.formulario.application;

import eapli.base.atributo.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.FormularioID;
import eapli.base.formulario.domain.FormularioNome;
import eapli.base.formulario.domain.FormularioScript;

import java.util.HashSet;
import java.util.Set;

public class FormularioController {
    private Set<Atributo> atributos = new HashSet<>();
    Formulario form;
    public void registo(FormularioNome nome, FormularioID id, FormularioScript script){
        form = new Formulario(script,id,nome);
    }
}
