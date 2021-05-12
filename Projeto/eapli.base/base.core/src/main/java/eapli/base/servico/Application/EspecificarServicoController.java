package eapli.base.servico.Application;

import eapli.base.catalogo.application.ListCatalogoService;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.FormularioID;
import eapli.base.formulario.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.base.servico.Repository.ServicoRepository;
import eapli.base.servico.builder.ServicoBuilder;
import eapli.base.servico.domain.*;

import java.util.ArrayList;
import java.util.Optional;

public class EspecificarServicoController {
    private Servico servico;
    private Servico servUp;
    ServicoBuilder builder = new ServicoBuilder();
    ServicoRepository repo = PersistenceContext.repositories().servico();
    CatalogRepository catRepo = PersistenceContext.repositories().catalogs();

    public void registo(ServicoDTO dto) {
        final Catalogo catalogo = catRepo.ofIdentity(dto.catalogo.identity).orElseThrow(() -> new IllegalArgumentException("Unknown catalog: " + dto.id));
        builder.Title(dto.title).Icon(dto.icon).Keywords(dto.keywords).Id(dto.id).Status(dto.status).briefDesc(dto.briefDescription).compDesc(dto.completeDescription).Catalogo(catalogo);
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

    public ArrayList<CatalogoDTO> catalogList() {
        ListCatalogoService lc = new ListCatalogoService();
        return lc.allCatalogos();
    }

    public void confirms() {
        repo.save(servico);
    }

    public ArrayList<ServicoDTO> getIncomplete() {
        return new ListServicoService().IncompleteServicos();
    }

    public Iterable<ServicoDTO> all() {
        return new ListServicoService().all();
    }

    public void ativarServico(ServicoDTO servicoDTO) {
        Optional<Servico> optionalServico = repo.ofIdentity(ServicoID.valueOf(servicoDTO.id));
        if (optionalServico.isPresent()) {
            Servico servico = optionalServico.get();
            servico.activate();
            repo.save(servico);
        }
    }

    public void desativarServico(ServicoDTO servicoDTO) {
        Optional<Servico> optionalServico = repo.ofIdentity(ServicoID.valueOf(servicoDTO.id));
        if (optionalServico.isPresent()) {
            Servico servico = optionalServico.get();
            servico.deactivate();
            repo.save(servico);
        }
    }

    public void update(ServicoDTO servicoDTO) {
        Optional<Servico> optionalServico = repo.ofIdentity(ServicoID.valueOf(servicoDTO.id));
        if (optionalServico.isPresent()) {
            Servico servico = optionalServico.get();
            servico.setBriedDesc(BriefDescription.valueOf(servicoDTO.briefDescription));
            servico.setCompDesc(CompleteDescription.valueOf(servicoDTO.completeDescription));
            servico.setIcon(IconServico.valueof(servicoDTO.icon));
            servico.setTitle(TituloServico.valueOf(servicoDTO.title));
            servico.setScript(ServicoScript.valueOf(servicoDTO.script));
            servico.addkeywords(KeyWords.valueOf(servicoDTO.keywords));
            repo.save(servico);
        }
    }

    public void updateForm(String formId, ServicoDTO serv) {
        Optional<Formulario> form = repo.getFormById(FormularioID.valueOf(formId));
        if (form.isPresent()){
            Optional<Servico> optionalServico = repo.ofIdentity(ServicoID.valueOf(serv.id));
            Formulario formu = form.get();
            if (optionalServico.isPresent()) {
                Servico servico = optionalServico.get();
                servico.setForm(formu);
                repo.save(servico);
            }
        }
    }
}
