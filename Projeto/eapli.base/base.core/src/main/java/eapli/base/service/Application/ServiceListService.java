package eapli.base.service.Application;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.service.Repository.ServiceRepository;
import eapli.base.service.domain.Service;

import java.util.ArrayList;

import java.util.List;

public class ServiceListService {
    private final ServiceRepository repo = PersistenceContext.repositories().servico();

    public ArrayList<ServiceDTO> IncompleteServicos() {
        ArrayList<ServiceDTO> serv = new ArrayList<>();
        for (Service ser : repo.incompleteServico()) {
            serv.add(ser.toDTO());
        }
        return serv;
    }

    public ArrayList<ServiceDTO> allServices() {
        ArrayList<ServiceDTO> serv = new ArrayList<>();
        for (Service ser : repo.findAll()) {
            serv.add(ser.toDTO());
        }
        return serv;
    }

    public Iterable<ServiceDTO> all() {
        ArrayList<ServiceDTO> serv = new ArrayList<>();
        for (Service ser : repo.findAll()) {
            serv.add(ser.toDTO());
        }
        return  serv;
    }

    public List<ServiceDTO> getServicoDTOByCatalogo(Catalogue catalogue){
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        for (Service service : repo.findAll()){
            if (service.catalogo().identity().equals(catalogue.identity())){
                serviceDTOList.add(service.toDTO());
            }
        }
        return serviceDTOList;

    }
}
