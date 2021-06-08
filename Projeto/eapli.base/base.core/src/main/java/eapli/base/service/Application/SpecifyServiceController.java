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
import eapli.base.task.application.TaskListService;
import eapli.base.task.domain.Task;
import eapli.base.utils.GenerateRandomStringID;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SpecifyServiceController {

    private final ServiceRepository serviceRepository = PersistenceContext.repositories().servico();
    private final CatalogueRepository catalogueRepository = PersistenceContext.repositories().catalogs();
    private Service service;
    private ServiceBuilder builder;
    private final ServiceListService serviceListService = new ServiceListService();

    public void create (ServiceDTO dto) {

        builder = new ServiceBuilder();
        final Catalogue catalogue = catalogueRepository.ofIdentity(dto.catalogo.identity).orElseThrow(() -> new IllegalArgumentException("Unknown catalog: " + dto.id));
        builder.withTitle(dto.title).withIcon(dto.icon).withKeywords(dto.keywords).withId(dto.id).withStatus(dto.status).withBriefDescription(dto.briefDescription).withCompleteDescription(dto.completeDescription).withCatalogue(catalogue);

    }

    public void automatic(String script) {

        service = builder.withScript(script).buildAutomatic();
    }

    public void manual(String id) {

        FormRepository formularyRepository = PersistenceContext.repositories().form();
        final Form form2 = formularyRepository.ofIdentity(FormID.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("Formulario desconhecido: " + id));
        formularyRepository.save(form2);
        service = builder.withForm(form2).buildManual();
    }

    public ArrayList<CatalogueDTO> catalogList() {

        ListCatalogueService catalogueServices = new ListCatalogueService();
        return catalogueServices.allCatalogos();
    }

    public void confirms() {
        serviceRepository.save(service);
    }

    public ArrayList<ServiceDTO> getIncomplete() {

        return new ServiceListService().incompleteServices();
    }

    public Iterable<ServiceDTO> all() {

        return new ServiceListService().allServices();
    }

    public void updateStatus(){
        this.service.updateStatus();
    }

    public void activateService(ServiceDTO serviceDTO) {

        Optional<Service> serviceOptional = serviceRepository.ofIdentity(ServiceID.valueOf(serviceDTO.id));

        if (serviceOptional.isPresent()) {
            Service service = serviceOptional.get();
            service.activate();
            serviceRepository.save(service);
        }
    }

    public void deactivateService( ServiceDTO serviceDTO ) {

        Optional<Service> serviceOptional = serviceRepository.ofIdentity(ServiceID.valueOf(serviceDTO.id));

        if (serviceOptional.isPresent()) {
            Service service = serviceOptional.get();
            service.deactivate();
            serviceRepository.save(service);
        }
    }

    public void update( ServiceDTO serviceDTO ) {

        Optional<Service> serviceOptional = serviceRepository.ofIdentity(ServiceID.valueOf(serviceDTO.id));

        if (serviceOptional.isPresent()) {
            Service service = serviceOptional.get();
            service.setBriedDesc(BriefDescription.valueOf(serviceDTO.briefDescription));
            service.setCompDesc(CompleteDescription.valueOf(serviceDTO.completeDescription));
            service.setIcon(IconServico.valueof(serviceDTO.icon));
            service.setTitle(ServiceTitle.valueOf(serviceDTO.title));
            service.setScript(ServiceScript.valueOf(serviceDTO.script));
            service.addkeywords(KeyWords.valueOf(serviceDTO.keywords));
            if (service.isComplete())
                service.deactivate();
            serviceRepository.save(service);
        }
    }



    public void updateForm( String formId, ServiceDTO serv ) {
        Optional<Form> serviceFormOptional = serviceRepository.getFormById(FormID.valueOf(formId));

        if (serviceFormOptional.isPresent()){
            Optional<Service> serviceOptional = serviceRepository.ofIdentity(ServiceID.valueOf(serv.id));
            Form serviceForm = serviceFormOptional.get();

            if (serviceOptional.isPresent()) {
                Service service = serviceOptional.get();
                service.setForm(serviceForm);
                serviceRepository.save(service);
            }
        }
    }

    public void addWorkflowToService(List<String> tasksID,ServiceDTO serviceDTO){
        TaskListService taskListService = new TaskListService();
        Task starterTask= taskListService.getTaskByStringList(tasksID);
        PersistenceContext.repositories().tasks().save(starterTask);
        Workflow workflow = new Workflow(GenerateRandomStringID.generateRandomStringID(),new Date(),starterTask);
        Service service = serviceListService.getServiceByID(serviceDTO.id);
        service.setWorkflow(workflow);
        serviceRepository.save(service);

    }

}
