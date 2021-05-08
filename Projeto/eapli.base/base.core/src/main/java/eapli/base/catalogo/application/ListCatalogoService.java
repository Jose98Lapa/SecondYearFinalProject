package eapli.base.catalogo.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListCatalogoService {
    private final CatalogRepository catalogoRepo = PersistenceContext.repositories().catalogs();

    public ArrayList<CatalogoDTO> allCatalogos(){
        ArrayList<CatalogoDTO> catalogos = new ArrayList<>();
        catalogoRepo.findAll().forEach(cat -> catalogos.add(cat.toDTO()));
        return catalogos;
    }

    public List<CatalogoDTO> allCompatibleCatalogo(Set<String> equipaTeste){
        ArrayList<CatalogoDTO>catalogos = new ArrayList<>();
        for (Catalogo catalogo: catalogoRepo.findAll()){
            if (catalogo.isTipoEquipaValido(equipaTeste)){
                catalogos.add(catalogo.toDTO());
            }
        }
        return catalogos;
    }
}
