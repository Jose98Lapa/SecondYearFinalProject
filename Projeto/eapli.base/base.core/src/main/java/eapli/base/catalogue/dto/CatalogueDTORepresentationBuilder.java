/*
package eapli.base.catalogo.dto;

import eapli.base.catalogo.domain.Status;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.general.domain.model.Money;
import eapli.framework.representations.RepresentationBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;



public class CatalogoDTORepresentationBuilder implements RepresentationBuilder<CatalogoDTO> {

    private static final Logger LOGGER = LogManager.getLogger(CatalogoDTORepresentationBuilder.class);

    private static final String PROPERTY_NOT_KNOW_IN_CATALOG_DTO = "Property '{}' not know in CATALOG DTO";

    private final CatalogoDTO dto = new CatalogoDTO();

    private String childObject = "";

    @Override
    public CatalogoDTO build() {
        return dto;
    }

    @Override
    public RepresentationBuilder<CatalogoDTO> startObject(final String name) {
        childObject = name;
        return this;
    }

    @Override
    public RepresentationBuilder<CatalogoDTO> endObject() {
        childObject = "";
        return this;
    }

    @Override
    public RepresentationBuilder<CatalogoDTO> withProperty(final String name, final String value) {
        if ("identity".equals(name)) {
            dto.catalogID = value;
        } else if ("title".equals(name) && "catalogo".equals(childObject)) {
            dto.catalogTitle = value;
        } else if ("icon".equals(name) && "catalogo".equals(childObject)) {
            dto.icon = value;
        } else if ("briefDesc".equals(name) && "catalogo".equals(childObject)) {
            dto.briefDesc = value;
        } else if ("completeDesc".equals(name) && "catalogo".equals(childObject)) {
            dto.completeDesc = value;
        } else {
            LOGGER.warn(PROPERTY_NOT_KNOW_IN_CATALOG_DTO, name);
        }
        return this;
    }

    @Override
    public RepresentationBuilder<CatalogoDTO> withElement(final String value) {
        LOGGER.warn("CATALOG DTO has no collections; tried to create element {}", value);
        return this;
    }
}
*/
