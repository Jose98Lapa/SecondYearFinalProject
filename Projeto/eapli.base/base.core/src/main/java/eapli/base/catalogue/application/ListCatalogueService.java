package eapli.base.catalogue.application;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListCatalogueService {
    private final CatalogueRepository catalogoRepo = PersistenceContext.repositories().catalogs();

    public ArrayList<CatalogueDTO> allCatalogos(){
        ArrayList<CatalogueDTO> catalogos = new ArrayList<>();
        catalogoRepo.findAll().forEach(cat -> catalogos.add(cat.toDTO()));
        return catalogos;
    }

    public List<CatalogueDTO> allCompatibleCatalogo(Set<String> equipaTeste){
        ArrayList<CatalogueDTO>catalogos = new ArrayList<>();
        for (Catalogue catalogue : catalogoRepo.findAll()){
            if (catalogue.isTipoEquipaValido(equipaTeste)){
                catalogos.add(catalogue.toDTO());
            }
        }
        return catalogos;
    }
}
