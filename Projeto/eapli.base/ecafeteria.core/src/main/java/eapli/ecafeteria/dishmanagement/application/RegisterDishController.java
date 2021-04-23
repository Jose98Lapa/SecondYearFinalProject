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

import java.util.Set;

import eapli.ecafeteria.dishmanagement.domain.Allergen;
import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.dishmanagement.domain.DishType;
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
 * The controller for the use case "register new dish" using the domain objects.
 *
 * @see eapli.ecafeteria.dishmanagement.application.viadto.RegisterDishViaDTOController
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@UseCaseController
public class RegisterDishController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListDishTypeService svcDishTypes = new ListDishTypeService();
    private final DishRepository dishRepository = PersistenceContext.repositories().dishes();
    private final ListAllergenService svcAllergens = new ListAllergenService();

    public Dish registerDish(final DishType dishType, final String name, final Integer calories,
            final Integer salt, final double price) {

        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);

        final Dish newDish = new Dish(dishType, Designation.valueOf(name), new NutricionalInfo(calories, salt),
                Money.euros(price));

        return dishRepository.save(newDish);
    }

    public Dish registerDish(final DishType dishType, final String name, final Integer calories,
            final Integer salt, final double price, final Set<Allergen> allergens) {

        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);

        final Dish newDish = new Dish(dishType, Designation.valueOf(name),
                new NutricionalInfo(calories, salt),
                Money.euros(price), allergens);

        return dishRepository.save(newDish);
    }

    public Iterable<Allergen> allAllergens() {
        return svcAllergens.allAllergens();
    }

    public Iterable<DishType> dishTypes() {
        return svcDishTypes.activeDishTypes();
    }
}
