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

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.representations.dto.DTO;

import java.util.Set;

@SuppressWarnings("squid:ClassVariableVisibilityCheck")
@DTO
public class CatalogoDTO {
    public String catalogID;
    public String catalogTitle;
    public String icon;
    public String briefDesc;
    public String completeDesc;
    public Set<EquipaDTO> accessCriteria;
    public Set<Colaborador> responsableCollabs;


    public CatalogoDTO(String catalogID, String catalogTitle, String icon,
                       String briefDesc, String completeDesc, Set<Colaborador> responsableCollabs, Set<Equipa> accessCriteria) {

        this.catalogID = catalogID;
        this.catalogTitle = catalogTitle;
        this.icon = icon;
        this.briefDesc = briefDesc;
        this.completeDesc = completeDesc;
        this.responsableCollabs = responsableCollabs;
        //responsableCollabs.forEach(a -> this.responsableCollabs.add(a.toDTO()));
        accessCriteria.forEach(a -> this.accessCriteria.add(a.toDTO()));
    }

    public CatalogoDTO() {
        // empty
    }
}
