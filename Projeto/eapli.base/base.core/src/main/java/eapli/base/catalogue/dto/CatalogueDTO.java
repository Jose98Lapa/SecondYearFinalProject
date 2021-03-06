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

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.domain.Team;
import eapli.framework.representations.dto.DTO;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("squid:ClassVariableVisibilityCheck")
@DTO
public class CatalogueDTO {

    public Long identity;
    public String catalogTitle;
    public String icon;
    public String briefDesc;
    public String completeDesc;
    public Set<TeamDTO> accessCriteria = new HashSet<>();
    public Set<CollaboratorDTO> responsableCollabs = new HashSet<>();
    public CriticalityDTO nivelCriticidade;


    public CatalogueDTO(Long identity, String catalogTitle, String icon,
                        String briefDesc, String completeDesc, Set<Collaborator> responsableCollabs,
                        Set<Team> accessCriteria, Criticality nivelCriticality) {

        this.identity = identity;
        this.catalogTitle = catalogTitle;
        this.icon = icon;
        this.briefDesc = briefDesc;
        this.completeDesc = completeDesc;
        responsableCollabs.forEach(a -> this.responsableCollabs.add(a.toDTO()));
        accessCriteria.forEach(a -> this.accessCriteria.add(a.toDTO()));
        this.nivelCriticidade = nivelCriticality.toDTO();
    }

    public CatalogueDTO() {
        // empty
    }

    @Override
    public String toString() {
        return  "ID: = " + identity +
                " Title: " + catalogTitle +
                " Icon=" + icon +
                " Brief Description: " + briefDesc +
                "\nComplete Description: '" + completeDesc +
                " Access Criteria: " + accessCriteria +
                " Responsible Collaborator: " + responsableCollabs ;
    }
}
