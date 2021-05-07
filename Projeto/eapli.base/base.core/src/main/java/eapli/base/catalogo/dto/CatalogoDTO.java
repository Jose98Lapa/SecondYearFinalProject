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

import eapli.base.catalogo.domain.AccessCriteria;
import eapli.base.colaborador.domain.MecanographicNumber;
import eapli.framework.representations.dto.DTO;

import java.util.List;

@SuppressWarnings("squid:ClassVariableVisibilityCheck")
@DTO
public class CatalogoDTO {
    public String catalogID;
    public String catalogTitle;

    public String icon;
    public String briefDesc;
    public String completeDesc;

    public List<AccessCriteria> accessCriteria;
    public MecanographicNumber responsableCollab;


    public CatalogoDTO(final String catalogID, final String catalogTitle,
                       final String icon,
                       final String briefDesc, final String completeDesc, List<AccessCriteria> accessCriteria,
                       final MecanographicNumber responsableCollab) {

    }

    public CatalogoDTO() {
        // empty
    }
}
