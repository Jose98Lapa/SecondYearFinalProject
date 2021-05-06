/*
 * Copyright (c) 2013-2020 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.catalogo.dto;

import eapli.base.catalogo.domain.Status;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.general.domain.model.Money;
import eapli.framework.representations.RepresentationBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * The builder for a CATALOGDTO using the RepresentationBuilder interface. This builder is forgiving in the sense that it
 * ignores properties that it doesn't understand in case the CATALOG has evolved to support new properties.
 *
 * @author Paulo Gandra de Sousa
 *
 */
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
