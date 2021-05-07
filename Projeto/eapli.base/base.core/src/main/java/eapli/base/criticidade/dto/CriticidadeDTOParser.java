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
package eapli.base.criticidade.dto;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.repository.CriticidadeRepository;
import eapli.framework.representations.dto.DTOParser;

/**
 *
 * @author Paulo Gandra de Sousa 2021/04/28
 *
 */
public class CriticidadeDTOParser implements DTOParser<CriticidadeDTO, Criticidade> {



    public CriticidadeDTOParser() {

    }

    @Override
    public Criticidade valueOf(final CriticidadeDTO dto) {
        /*
        final DishType type = dishTypeRepository.ofIdentity(dto.dishTypeAcronym)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unknown dish type: " + dto.dishTypeAcronym));
        */

        // TODO: we are ignoring the currency and hardcoding everything is EUR
        //return new Criticidade();
        return null;
    }
}
