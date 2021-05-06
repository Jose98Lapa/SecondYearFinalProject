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
package eapli.base.criticidade.dto;

import eapli.framework.representations.RepresentationBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The builder for a DishDTO using the RepresentationBuilder interface. This builder is forgiving in the sense that it
 * ignores properties that it doesn't understand in case the Dish has evolved to support new properties.
 *
 * @author Paulo Gandra de Sousa
 *
 */
public class CriticidadeDTORepresentationBuilder implements RepresentationBuilder<CriticidadeDTO> {

    private static final Logger LOGGER = LogManager.getLogger(CriticidadeDTO.class);

    private static final String PROPERTY_NOT_KNOW_IN_DISH_DTO = "Property '{}' not know in dishDTO";

    private final CriticidadeDTO dto = null; //new CriticidadeDTO()

    private String childObject = "";

    @Override
    public CriticidadeDTO build() {
        return dto;
    }

    @Override
    public RepresentationBuilder<CriticidadeDTO> withElement(String value) {
        return null;
    }

    @Override
    public RepresentationBuilder<CriticidadeDTO> withProperty(String name, String value) {
        return null;
    }
}
