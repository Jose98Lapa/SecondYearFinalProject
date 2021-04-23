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
package eapli.ecafeteria.infrastructure.bootstrapers.demo;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.dishmanagement.repositories.DishRepository;
import eapli.ecafeteria.infrastructure.bootstrapers.TestDataConstants;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.mealmanagement.application.RegisterMealController;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.domain.MealType;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.time.util.Calendars;

/**
 *
 * @author losa
 */
public class MealBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(MealBootstrapper.class);

    private final RegisterMealController controller = new RegisterMealController();
    private final DishRepository repo = PersistenceContext.repositories().dishes();

    @Override
    public boolean execute() {
        final Dish bacalhau = repo
                .ofIdentity(Designation.valueOf(TestDataConstants.DISH_NAME_BACALHAU_A_BRAZ))
                .orElseThrow(IllegalStateException::new);
        final Dish picanha = repo
                .ofIdentity(Designation.valueOf(TestDataConstants.DISH_NAME_PICANHA))
                .orElseThrow(IllegalStateException::new);
        final Dish lentilhas = repo
                .ofIdentity(Designation.valueOf(TestDataConstants.DISH_NAME_LENTILHAS_SALTEADAS))
                .orElseThrow(IllegalStateException::new);

        final Calendar afterTomorrow = Calendars.tomorrow();
        afterTomorrow.add(Calendar.DATE, 1);

        register(MealType.LUNCH, Calendars.now(), bacalhau);
        register(MealType.DINNER, Calendars.now(), bacalhau);

        register(MealType.LUNCH, Calendars.tomorrow(), bacalhau);
        register(MealType.DINNER, Calendars.tomorrow(), bacalhau);

        register(MealType.LUNCH, afterTomorrow, bacalhau);
        register(MealType.DINNER, afterTomorrow, bacalhau);

        register(MealType.LUNCH, Calendars.now(), picanha);
        register(MealType.DINNER, Calendars.now(), picanha);

        register(MealType.LUNCH, Calendars.tomorrow(), picanha);
        register(MealType.DINNER, Calendars.tomorrow(), picanha);

        register(MealType.LUNCH, afterTomorrow, lentilhas);
        register(MealType.DINNER, afterTomorrow, lentilhas);

        register(MealType.LUNCH, Calendars.now(), lentilhas);
        register(MealType.DINNER, Calendars.now(), lentilhas);

        register(MealType.LUNCH, Calendars.tomorrow(), lentilhas);
        register(MealType.DINNER, Calendars.tomorrow(), lentilhas);

        register(MealType.LUNCH, afterTomorrow, picanha);
        register(MealType.DINNER, afterTomorrow, picanha);

        register(TestDataConstants.MEAL_TYPE_TO_BOOK, TestDataConstants.DATE_TO_BOOK, bacalhau);

        return true;
    }

    private void register(final MealType mealType, final Calendar ofDay, final Dish dish) {
        try {
            final Meal m = controller.registerMeal(mealType, ofDay, dish);
            LOGGER.debug("»»» {}", m);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", "meal");
            LOGGER.trace("Assuming existing record", e);
        }
    }
}
