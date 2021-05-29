package eapli.base.service.Application;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.form.DTO.FormDTO;
import eapli.base.form.domain.Form;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.service.Repository.ServiceRepository;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceID;
import eapli.base.service.domain.ServiceStatus;
import eapli.base.service.domain.ServiceTitle;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

public class ServiceListService {
    private final ServiceRepository serviceRepository = PersistenceContext.repositories().servico();

    public ArrayList<ServiceDTO> incompleteServices() {

        ArrayList<ServiceDTO> services = new ArrayList<>();

        for ( Service service : serviceRepository.incompleteServico() ) {
            services.add(service.toDTO());
        }

        return services;
    }

    public ArrayList<ServiceDTO> allServices() {

        ArrayList<ServiceDTO> services = new ArrayList<>();

        for (Service service : serviceRepository.findAll() ) {
            services.add( service.toDTO() );
        }

        return services;
    }

    public List<ServiceDTO> getServiceDTOByCatalogueAndTitle( Catalogue catalogue,String query,String parameter ) {

        List<ServiceDTO> serviceDTOList = new ArrayList<>();

        for ( Service service : serviceRepository.getServiceListByCatalogueAndTitle( catalogue,query, ServiceTitle.valueOf( parameter ) ) ){
            serviceDTOList.add( service.toDTO() );
        }

        return serviceDTOList;
    }

    public List<ServiceDTO> getServiceDTOByCatalogueAndID( Catalogue catalogue,String query,String parameter ) {

        List<ServiceDTO> serviceDTOList = new ArrayList<>();

        for ( Service service : serviceRepository.getServiceListByCatalogueAndID( catalogue,query, ServiceID.valueOf( parameter ) ) ){
            serviceDTOList.add( service.toDTO() );
        }

        return serviceDTOList;
    }

    public List<ServiceDTO> getServiceDTOByCatalogueAndStatus( Catalogue catalogue,String query,String parameter ) {

        List<ServiceDTO> serviceDTOList = new ArrayList<>();

        for ( Service service : serviceRepository.getServiceListByCatalogueAndStatus(catalogue,query, ServiceStatus.valueOf(parameter)) ){
            serviceDTOList.add(service.toDTO());
        }

        return serviceDTOList;
    }

    public List<ServiceDTO> getServiceDTOByCatalogue(Catalogue catalogue,String query){

        List<ServiceDTO> serviceDTOList = new ArrayList<>();

        for (Service service : serviceRepository.getServiceListByCatalogue(catalogue,query)){
           serviceDTOList.add(service.toDTO());
        }

        return serviceDTOList;

    }

    public List<ServiceDTO> getServiceDTOListByCatalogue ( Catalogue catalogue ){

        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        String query = "Select e From eapli.base.service.domain.Service e where e.catalogue =: catalogue";

        for (Service service : serviceRepository.getServiceListByCatalogue( catalogue, query ) ){
            serviceDTOList.add( service.toDTO() );
        }

        return serviceDTOList;

    }

    public Optional < FormDTO > retrieveServiceForm ( ServiceID serviceID ){

        Optional< Service > serviceOptional = serviceRepository.findByServicoID( serviceID );
        Optional < Form > formOptional;
        FormDTO formDTO = null;

        if ( serviceOptional.isPresent() ) {
            Service service = serviceOptional.get();
            formOptional = serviceRepository.getFormById( service.form( ).identity() );

            if ( formOptional.isPresent() ) {
                formDTO = ( formOptional.get() ).toDTO();
            }
        }

        return Optional.ofNullable( formDTO );
    }

    public Service getServiceByID(String id){
        Optional<Service> optionalService = serviceRepository.ofIdentity(ServiceID.valueOf(id));
        if (optionalService.isEmpty())
            throw new IllegalArgumentException("Invalid Service");
        return optionalService.get();
    }
}
