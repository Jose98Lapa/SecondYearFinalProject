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
package eapli.ecafeteria.dishmanagement.application.viadto;

import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.dishmanagement.domain.NutricionalInfo;
import eapli.ecafeteria.dishmanagement.dto.DishDTO;
import eapli.ecafeteria.dishmanagement.dto.DishTypeDTO;
import eapli.ecafeteria.dishmanagement.repositories.DishRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * The controller for the use case "register new dish" using DTOs.
 * <p>
 * Since this controller works with DTOs it must transform from DTOs to domain
 * objects and vice-versa whenever interfacing the presentation and domain
 * layers. Also, some some related domain object is needed it must first be
 * retrieved from the repository prior to its use
 * </p>
 *
 * @see eapli.ecafeteria.dishmanagement.application.RegisterDishController
 *
 * @author Paulo Gandra de Sousa
 */
@UseCaseController
public class RegisterDishViaDTOController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListDishTypeDTOService svc = new ListDishTypeDTOService();

    private final DishRepository dishRepository = PersistenceContext.repositories().dishes();
    private final DishTypeRepository dishTypeRepository = PersistenceContext.repositories()
            .dishTypes();

    public void registerDish(final DishDTO dto) {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);

        // retrieve the dish type
        final DishType type = dishTypeRepository.ofIdentity(dto.dishTypeAcronym)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unknown dish type: " + dto.dishTypeAcronym));

        // TODO: we are ignoring the currency and hardcoding everything is EUR
        final Dish newDish = new Dish(type, Designation.valueOf(dto.name),
                new NutricionalInfo(dto.calories, dto.salt),
                Money.euros(dto.price));

        this.dishRepository.save(newDish);
    }

    public Iterable<DishTypeDTO> dishTypes() {
        return this.svc.activeDishTypes();
    }
}
