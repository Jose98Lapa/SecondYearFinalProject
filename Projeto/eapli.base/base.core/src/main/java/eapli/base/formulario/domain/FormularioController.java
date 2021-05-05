package eapli.base.formulario.domain;

public class FormularioController {
    Formulario form;
    public void registo(FormularioNome nome,FormularioID id, FormularioScript script){
        form = new Formulario(script,id,nome);
    }
}
