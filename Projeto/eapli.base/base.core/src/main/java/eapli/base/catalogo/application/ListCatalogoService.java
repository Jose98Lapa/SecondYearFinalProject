package eapli.base.catalogo.application;

import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;

public class ListCatalogoService {
    private final CatalogRepository catalogoRepo = PersistenceContext.repositories().catalogs();

    public ArrayList<CatalogoDTO> allCatalogos(){
        ArrayList<CatalogoDTO> catalogos = new ArrayList<>();
        catalogoRepo.findAll().forEach(cat -> catalogos.add(cat.toDTO()));
        return catalogos;
    }
}
