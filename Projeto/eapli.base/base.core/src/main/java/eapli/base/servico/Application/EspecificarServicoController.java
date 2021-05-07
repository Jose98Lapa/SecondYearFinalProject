package eapli.base.servico.Application;

import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.builder.ServicoBuilder;
import eapli.base.servico.domain.*;

import java.util.Set;

public class EspecificarServicoController {
    private Servico servico;
     ServicoBuilder builder = new ServicoBuilder();

    public void registoComplete(String title, String id, String icon, Set<String> keywords,String briefDesc,String compDesc){
            builder.Title(title).Icon(icon).Keywords(keywords).Id(id).Status("COMPLETE").briefDesc(briefDesc).compDesc(compDesc);
    }
    public void registoIncomplete(String title, String id){
            builder.Title(title).Id(id);
    }
    public void automatic(String script){
       servico = builder.Script(script).buildAutomatic();
    }
    public void  manual(Formulario form){
        servico = builder.Form(form).buildManual();
    }

}
