/*
 * Copyright (c) 2013-2021 the original author or authors.
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

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.ecafeteria.dishmanagement.domaintion.Dish;
import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.dishmanagement.domain.NutricionalInfo;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.Money;
import eapli.framework.representations.dto.DTOParser;

/**
 *
 * @author Paulo Gandra de Sousa 2021/04/28
 *
 */
public class CatalogoDTOParser implements DTOParser<CatalogoDTO, Catalogo> {

    private final CatalogRepository catalogRepository;

    public CatalogoDTOParser(final CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Catalogo valueOf(final CatalogoDTO dto) {
        /*
        final DishType type = dishTypeRepository.ofIdentity(dto.dishTypeAcronym)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unknown dish type: " + dto.dishTypeAcronym));
        */

        //return new Catalogo(type, Designation.valueOf(dto.name),new NutricionalInfo(dto.calories, dto.salt), Money.euros(dto.price));
        return null;
    }
}
