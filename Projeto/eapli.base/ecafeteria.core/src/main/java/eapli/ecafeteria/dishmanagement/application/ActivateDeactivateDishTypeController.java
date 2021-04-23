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
package eapli.ecafeteria.dishmanagement.application;

import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author mcn
 */
@UseCaseController
public class ActivateDeactivateDishTypeController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListDishTypeService svc = new ListDishTypeService();
    private final DishTypeRepository dishTypeRepository = PersistenceContext.repositories().dishTypes();

    public Iterable<DishType> allDishTypes() {
        return this.svc.allDishTypes();
    }

    public DishType changeDishTypeState(final DishType dType) {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER, CafeteriaRoles.MENU_MANAGER);
        if (dType == null) {
            throw new IllegalArgumentException();
        }
        dType.toogleState();
        return this.dishTypeRepository.save(dType);
    }
}
