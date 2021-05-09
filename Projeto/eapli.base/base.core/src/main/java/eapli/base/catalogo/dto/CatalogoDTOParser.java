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

import eapli.base.catalogo.builder.CatalogBuilder;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTOParser;
import eapli.base.criticidade.dto.CriticidadeDTOParser;
import eapli.base.equipa.DTO.EquipaDTOParser;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.representations.dto.DTOParser;

import java.util.HashSet;
import java.util.Set;

public class CatalogoDTOParser implements DTOParser<CatalogoDTO, Catalogo> {

    public CatalogoDTOParser() {
        //empty
    }

    @Override
    public Catalogo valueOf(CatalogoDTO dto) {
        CatalogBuilder builder = new CatalogBuilder();

        final Set<Equipa> accessCriteria = new HashSet<>();
        dto.accessCriteria.forEach( a -> accessCriteria.add(new EquipaDTOParser().valueOf(a)));

        final Set<Colaborador> lstResponsable = new HashSet<>();
        dto.responsableCollabs.forEach( a -> lstResponsable.add(new ColaboradorDTOParser().valueOf(a)));

        return builder.withTitle(dto.catalogTitle).withIcon(dto.icon)
                .withBriefDesc(dto.briefDesc).withCompleteDesc(dto.completeDesc)
                .withResponsableCollabs(lstResponsable).withAccessCriteria(accessCriteria).withIdentity(dto.identity).withNivelCriticidade(new CriticidadeDTOParser().valueOf(dto.nivelCriticidade)).build();
    }

}
