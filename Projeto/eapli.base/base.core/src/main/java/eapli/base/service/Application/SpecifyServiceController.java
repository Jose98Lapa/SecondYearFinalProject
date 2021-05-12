package eapli.base.service.Application;

import eapli.base.catalogue.application.ListCatalogueService;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.repository.FormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.service.Repository.ServiceRepository;
import eapli.base.service.builder.ServiceBuilder;
import eapli.base.service.domain.*;

import java.util.ArrayList;
import java.util.Optional;

public class SpecifyServiceController {
    private Service service;
    private Service servUp;
    ServiceBuilder builder = new ServiceBuilder();
    ServiceRepository repo = PersistenceContext.repositories().servico();
    CatalogueRepository catRepo = PersistenceContext.repositories().catalogs();

    public void registo(ServiceDTO dto) {
        final Catalogue catalogue = catRepo.ofIdentity(dto.catalogo.identity).orElseThrow(() -> new IllegalArgumentException("Unknown catalog: " + dto.id));
        builder.Title(dto.title).Icon(dto.icon).Keywords(dto.keywords).Id(dto.id).Status(dto.status).briefDesc(dto.briefDescription).compDesc(dto.completeDescription).Catalogo(catalogue);
    }

    public void automatic(String script) {
        service = builder.Script(script).buildAutomatic();
    }

    public void manual(String id) {
        FormRepository repo = PersistenceContext.repositories().form();
        final Form form2 = repo.ofIdentity(FormID.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("Formulario desconhecido: " + id));

        service = builder.Form(form2).buildManual();
    }

    public ArrayList<CatalogueDTO> catalogList() {
        ListCatalogueService lc = new ListCatalogueService();
        return lc.allCatalogos();
    }

    public void confirms() {
        repo.save(service);
    }

    public ArrayList<ServiceDTO> getIncomplete() {
        return new ServiceListService().IncompleteServicos();
    }

    public Iterable<ServiceDTO> all() {
        return new ServiceListService().all();
    }

    public void ativarServico(ServiceDTO serviceDTO) {
        Optional<Service> optionalServico = repo.ofIdentity(ServiceID.valueOf(serviceDTO.id));
        if (optionalServico.isPresent()) {
            Service service = optionalServico.get();
            service.activate();
            repo.save(service);
        }
    }

    public void desativarServico(ServiceDTO serviceDTO) {
        Optional<Service> optionalServico = repo.ofIdentity(ServiceID.valueOf(serviceDTO.id));
        if (optionalServico.isPresent()) {
            Service service = optionalServico.get();
            service.deactivate();
            repo.save(service);
        }
    }

    public void update(ServiceDTO serviceDTO) {
        Optional<Service> optionalServico = repo.ofIdentity(ServiceID.valueOf(serviceDTO.id));
        if (optionalServico.isPresent()) {
            Service service = optionalServico.get();
            service.setBriedDesc(BriefDescription.valueOf(serviceDTO.briefDescription));
            service.setCompDesc(CompleteDescription.valueOf(serviceDTO.completeDescription));
            service.setIcon(IconServico.valueof(serviceDTO.icon));
            service.setTitle(ServiceTitle.valueOf(serviceDTO.title));
            service.setScript(ServiceScript.valueOf(serviceDTO.script));
            service.addkeywords(KeyWords.valueOf(serviceDTO.keywords));
            repo.save(service);
        }
    }

    public void updateForm(String formId, ServiceDTO serv) {
        Optional<Form> form = repo.getFormById(FormID.valueOf(formId));
        if (form.isPresent()){
            Optional<Service> optionalServico = repo.ofIdentity(ServiceID.valueOf(serv.id));
            Form formu = form.get();
            if (optionalServico.isPresent()) {
                Service service = optionalServico.get();
                service.setForm(formu);
                repo.save(service);
            }
        }
    }
}
