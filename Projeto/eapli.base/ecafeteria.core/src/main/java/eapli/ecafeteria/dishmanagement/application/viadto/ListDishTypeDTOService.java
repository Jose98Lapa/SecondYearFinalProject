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
package eapli.ecafeteria.dishmanagement.application.viadto;

import java.util.ArrayList;
import java.util.List;

import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.dishmanagement.dto.DishTypeDTO;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * an application service to avoid code duplication.
 *
 * since this service works with DTOs it must transform from DTOs to domain
 * objects and vice versa whenever interfacing the presentation and domain
 * layers.
 *
 * @author Paulo Gandra de Sousa
 */
@ApplicationService
class ListDishTypeDTOService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final DishTypeRepository dishTypeRepository = PersistenceContext.repositories()
            .dishTypes();

    public Iterable<DishTypeDTO> allDishTypes() {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);

        final Iterable<DishType> types = this.dishTypeRepository.findAll();
        return transformToDTO(types);
    }

    private Iterable<DishTypeDTO> transformToDTO(final Iterable<DishType> types) {
        // transform for the presentation layer
        final List<DishTypeDTO> ret = new ArrayList<>();
        types.forEach(e -> ret.add(e.toDTO()));
        return ret;
    }

    public Iterable<DishTypeDTO> activeDishTypes() {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);

        return transformToDTO(this.dishTypeRepository.activeDishTypes());
    }
}
