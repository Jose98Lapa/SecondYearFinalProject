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
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.validations.Invariants;

/**
 * An example of a controller using a pessimistic lock strategy.
 * <p>
 * By default, the framework repositories (and JPA) will use optimistic locking for managed entities
 * with version fields, so in order to have a pessimistic lock we need to maintain an active
 * transaction for the whole use case. This must be carefully used as it will limit the ability of
 * the application to scale, specially in interactive use cases like this one where the user might
 * hold the transaction for quite some time.
 * <p>
 * For interactive use cases, one must understand that this approach only works in "connected"
 * environments like GUI and CLI. On a "disconnected" environment like a web application or web
 * service pessimistic locking based on the user interaction must be handled with a locking table.
 *
 * @see ChangeDishTypeController
 * @author Paulo Gandra Sousa 2021.03.30
 */
@UseCaseController
public class ChangeDishTypePessimisticLockController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    // since we want this use case to hold a pessimistic lock we need to maintain a transaction open
    // during the whole use case
    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final DishTypeRepository repo = PersistenceContext.repositories().dishTypes(txCtx);

    // since we use a pessimistic lock we will hold the desired object on the controller state
    private DishType theDishType;

    /**
     * Changes the locked object and releases the lock so other processes can access it.
     *
     * @param newDescription
     * @return
     */
    public DishType changeDishType(final String newDescription) {
        Invariants.ensure(txCtx.isActive());
        Invariants.nonNull(theDishType);

        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER, CafeteriaRoles.MENU_MANAGER);

        if (theDishType == null) {
            throw new IllegalArgumentException();
        }

        theDishType.changeDescriptionTo(newDescription);

        final var updatedDishType = repo.save(theDishType);

        // since we are in a pessimistic lock mode, we must explicitly commit the transaction
        txCtx.commit();

        return updatedDishType;
    }

    /**
     * In the context of this use case only active dish types are meaningful.
     *
     * @return all active dish types
     */
    public Iterable<DishType> dishTypes() {
        // since we are in a pessimistic lock mode, we must explicitly begin a transaction
        txCtx.beginTransaction();
        // we use the repository directly and not the {@link ListDishTypeService} to make sure the
        // returned objects are in the entity manager so we can lock them
        return repo.activeDishTypes();
    }

    /**
     * Indicates which object we want to change. A lock will be issued on this object and other
     * processes won't be able to change this object until we finish the use case by calling
     * {@link #changeDishType(String)}
     *
     * @param aDishType
     */
    public DishType grantExclusiveAccessTo(final DishType aDishType) {
        theDishType = repo.lockItUp(aDishType);
        return theDishType;
    }
}
