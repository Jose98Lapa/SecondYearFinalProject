package eapli.base.servico.Application;

import eapli.base.formulario.domain.Formulario;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.base.servico.Repository.ServicoRepository;
import eapli.base.servico.builder.ServicoBuilder;
import eapli.base.servico.domain.*;

public class EspecificarServicoController {
    private Servico servico;
    ServicoBuilder builder = new ServicoBuilder();

    public void registo(ServicoDTO dto) {
        builder.Title(dto.title).Icon(dto.icon).Keywords(dto.keywords).Id(dto.id).Status("INATIVO").briefDesc(dto.briefDescription).compDesc(dto.completeDescription);
    }

    public void automatic(String script) {
        servico = builder.Script(script).buildAutomatic();
    }

    public void manual(Formulario form) {
        servico = builder.Form(form).buildManual();
    }

    public void confirms(){
        ServicoRepository repo = PersistenceContext.repositories().servico();
        repo.save(servico);
    }

}
