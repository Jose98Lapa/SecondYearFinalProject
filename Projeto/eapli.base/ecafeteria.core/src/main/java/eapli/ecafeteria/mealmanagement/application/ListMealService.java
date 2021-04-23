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
package eapli.ecafeteria.mealmanagement.application;

import java.util.Calendar;

import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.domain.MealType;
import eapli.ecafeteria.mealmanagement.repositories.MealRepository;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author losa
 */
@ApplicationService
public class ListMealService {
    private final MealRepository mealRepository = PersistenceContext.repositories().meals();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

    public Iterable<Meal> allMeals() {
        authorizationService.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER,
                CafeteriaRoles.KITCHEN_MANAGER);
        return mealRepository.findAll();
    }

    public Iterable<Meal> mealsOnPeriod(final Calendar beginDate, final Calendar endDate) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);
        return mealRepository.findByPeriod(beginDate, endDate);
    }

    public Iterable<Meal> mealsByDayAndType(final Calendar theDay, final MealType mealType) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.CAFETERIA_USER);
        return mealRepository.findByDayAndType(theDay, mealType);
    }
}
