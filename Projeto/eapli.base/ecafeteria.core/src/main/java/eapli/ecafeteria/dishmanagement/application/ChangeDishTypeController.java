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

import java.util.Optional;

import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * An example of a controller using an optimistic lock strategy.
 * <p>
 * By default, the framework repositories (and JPA) will use optimistic locking for managed entities
 * with version fields, so there is nothing special to do.
 *
 * @see ChangeDishTypePessimisticLockController
 * @author Nuno
 */
@UseCaseController
public class ChangeDishTypeController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListDishTypeService listDishTypesSvc = new ListDishTypeService();
    private final DishTypeRepository repo = PersistenceContext.repositories().dishTypes();

    /**
     *
     * @param theDishType
     * @param newDescription
     * @return
     */
    public DishType changeDishType(final DishType theDishType, final String newDescription) {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER, CafeteriaRoles.MENU_MANAGER);

        if (theDishType == null) {
            throw new IllegalArgumentException();
        }

        theDishType.changeDescriptionTo(newDescription);

        return repo.save(theDishType);
    }

    /**
     * In the context of this use case only active dish types are meaningful.
     *
     * @return all active dish types
     */
    public Iterable<DishType> dishTypes() {
        return listDishTypesSvc.activeDishTypes();
    }

    /**
     *
     * @param id
     * @return the specified dish type if it exists and is active
     */
    public Optional<DishType> searchDishType(final String id) {
        return repo.ofIdentity(id).filter(DishType::isActive);
    }
}
