package eapli.base.service.Application;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.service.Repository.ServiceRepository;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceID;
import eapli.base.service.domain.ServiceStatus;
import eapli.base.service.domain.ServiceTitle;

import java.util.ArrayList;

import java.util.List;

public class ServiceListService {
    private final ServiceRepository repo = PersistenceContext.repositories().servico();

    public ArrayList<ServiceDTO> incompleteServices() {

        ArrayList<ServiceDTO> services = new ArrayList<>();

        for ( Service service : repo.incompleteServico() ) {
            services.add( service.toDTO() );
        }

        return services;
    }

    public ArrayList<ServiceDTO> allServices() {

        ArrayList<ServiceDTO> services = new ArrayList<>();

        for (Service service : repo.findAll() ) {
            services.add( service.toDTO() );
        }

        return services;
    }

    public List<ServiceDTO> getServiceDTOByCatalogueAndTitle( Catalogue catalogue,String query,String parameter ) {

        List<ServiceDTO> serviceDTOList = new ArrayList<>();

        for ( Service service : repo.getServiceListByCatalogueAndTitle( catalogue,query, ServiceTitle.valueOf( parameter ) ) ){
            serviceDTOList.add( service.toDTO() );
        }

        return serviceDTOList;
    }

    public List<ServiceDTO> getServiceDTOByCatalogueAndID( Catalogue catalogue,String query,String parameter ) {

        List<ServiceDTO> serviceDTOList = new ArrayList<>();

        for ( Service service : repo.getServiceListByCatalogueAndID( catalogue,query, ServiceID.valueOf( parameter ) ) ){
            serviceDTOList.add( service.toDTO() );
        }

        return serviceDTOList;
    }

    public List<ServiceDTO> getServiceDTOByCatalogueAndStatus( Catalogue catalogue,String query,String parameter ) {

        List<ServiceDTO> serviceDTOList = new ArrayList<>();

        for ( Service service : repo.getServiceListByCatalogueAndStatus(catalogue,query, ServiceStatus.valueOf(parameter)) ){
            serviceDTOList.add(service.toDTO());
        }

        return serviceDTOList;
    }

    public List<ServiceDTO> getServiceDTOByCatalogue(Catalogue catalogue,String query){

        List<ServiceDTO> serviceDTOList = new ArrayList<>();

        for (Service service : repo.getServiceListByCatalogue(catalogue,query)){
           serviceDTOList.add(service.toDTO());
        }

        return serviceDTOList;

    }
}
