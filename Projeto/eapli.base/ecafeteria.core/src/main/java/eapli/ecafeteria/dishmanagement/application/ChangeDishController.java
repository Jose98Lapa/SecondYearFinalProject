/*
 * Copyright (c) 2013-2020 the original author or authors.
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

import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.dishmanagement.domain.NutricionalInfo;
import eapli.ecafeteria.dishmanagement.repositories.DishRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author PRP
 */
@UseCaseController
public class ChangeDishController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListDishService svc = new ListDishService();
    private final DishRepository dishRepository = PersistenceContext.repositories().dishes();

    public Iterable<Dish> allDishes() {
        return this.svc.allDishes();
    }

    public Optional<Dish> searchDish(String id) {
        return dishRepository.ofIdentity(Designation.valueOf(id));
    }

    public Dish changeDishPrice(final Dish dish, final Money newPrice) {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);
        if (dish == null) {
            throw new IllegalArgumentException();
        }
        dish.changePriceTo(newPrice);

        return this.dishRepository.save(dish);
    }

    public Dish changeDishNutricionalInfo(final Dish dish,
            final NutricionalInfo newNutricionalInfo) {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);
        if (dish == null) {
            throw new IllegalArgumentException();
        }
        dish.changeNutricionalInfoTo(newNutricionalInfo);

        return this.dishRepository.save(dish);
    }
}
