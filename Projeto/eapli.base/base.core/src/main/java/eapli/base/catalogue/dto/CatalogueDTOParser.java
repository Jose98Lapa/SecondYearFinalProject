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
package eapli.base.catalogue.dto;

import eapli.base.catalogue.builder.CatalogueBuilder;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.dto.CollaboratorDTOParser;
import eapli.base.criticality.dto.CriticalityDTOParser;
import eapli.base.team.DTO.TeamDTOParser;
import eapli.base.team.domain.Team;
import eapli.framework.representations.dto.DTOParser;

import java.util.HashSet;
import java.util.Set;

public class CatalogueDTOParser implements DTOParser<CatalogueDTO, Catalogue> {

    public CatalogueDTOParser() {
        //empty
    }

    @Override
    public Catalogue valueOf(CatalogueDTO dto) {
        CatalogueBuilder builder = new CatalogueBuilder();

        final Set<Team> accessCriteria = new HashSet<>();
        dto.accessCriteria.forEach( a -> accessCriteria.add(new TeamDTOParser().valueOf(a)));

        final Set<Collaborator> lstResponsable = new HashSet<>();
        dto.responsableCollabs.forEach( a -> lstResponsable.add(new CollaboratorDTOParser().valueOf(a)));

        return builder.withTitle(dto.catalogTitle).withIcon(dto.icon)
                .withBriefDesc(dto.briefDesc).withCompleteDesc(dto.completeDesc)
                .withResponsableCollabs(lstResponsable).withAccessCriteria(accessCriteria).withIdentity(dto.identity).withNivelCriticidade(new CriticalityDTOParser().valueOf(dto.nivelCriticidade)).build();
    }

}
