package eapli.base.servico.Application;

import eapli.base.catalogo.application.ListCatalogoService;
import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.catalogo.dto.CatalogoDTOParser;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.FormularioID;
import eapli.base.formulario.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.base.servico.Repository.ServicoRepository;
import eapli.base.servico.builder.ServicoBuilder;
import eapli.base.servico.domain.*;

import java.util.ArrayList;

public class EspecificarServicoController {
    private Servico servico;
    ServicoBuilder builder = new ServicoBuilder();
    ServicoRepository repo = PersistenceContext.repositories().servico();

    public void registo(ServicoDTO dto) {
        builder.Title(dto.title).Icon(dto.icon).Keywords(dto.keywords).Id(dto.id).Status(dto.status).briefDesc(dto.briefDescription).compDesc(dto.completeDescription).Catalogo(new CatalogoDTOParser().valueOf(dto.catalogo));
    }

    public void automatic(String script) {
        servico = builder.Script(script).buildAutomatic();
    }

    public void manual(String id) {
            FormularioRepository repo = PersistenceContext.repositories().form();
            final Formulario form2 = repo.ofIdentity(FormularioID.valueOf(id))
                    .orElseThrow(() -> new IllegalArgumentException("Formulario desconhecido: " + id));


        servico = builder.Form(form2).buildManual();
    }
    public ArrayList<CatalogoDTO> catalogList(){
        ListCatalogoService lc = new ListCatalogoService();
        return lc.allCatalogos();
    }

    public void confirms(){
        repo.save(servico);
    }

    public ArrayList<ServicoDTO> getIncomplete(){
        return new ListServicoService().IncompleteServicos();
    }

    public Iterable<ServicoDTO> all(){
        return new ListServicoService().all();
    }

    public void ativarServico(String servicoId){
        repo.ativar(servicoId);

    }
    public void desativarServico(String servicoId){
        repo.desativar(servicoId);
    }

}
