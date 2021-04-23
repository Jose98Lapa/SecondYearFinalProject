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
package eapli.ecafeteria.mealbooking.application;

import java.util.Calendar;

import eapli.ecafeteria.Application;
import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.cafeteriausermanagement.domain.MecanographicNumber;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CafeteriaUserRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.mealbooking.domain.BookingToken;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.domain.MealType;
import eapli.ecafeteria.mealmanagement.repositories.MealRepository;

/**
 *
 * @author Paulo Gandra Sousa
 *
 */
public class BookAMealForADayControllerImpl implements BookAMealForADayController {

    private final MealRepository mealRepo = PersistenceContext.repositories().meals();
    private final CafeteriaUserRepository userRepo = PersistenceContext.repositories().cafeteriaUsers();

    /**
     *
     * @param when
     * @param forMeal
     * @return
     */
    @Override
    public Iterable<Meal> getMealsOfADay(final Calendar when, final MealType forMeal) {
        return mealRepo.findByDayAndType(when, forMeal);
    }

    /**
     *
     * @param mealId
     * @param booker
     * @return
     */
    @Override
    public BookingToken bookMeal(final Long mealId, final MecanographicNumber booker) {
        final Meal meal = mealRepo.ofIdentity(mealId).orElseThrow(IllegalArgumentException::new);
        final CafeteriaUser user = userRepo.ofIdentity(booker).orElseThrow(IllegalArgumentException::new);
        return bookMeal(meal, user);
    }

    /**
     *
     * @param meal
     * @param booker
     * @return
     * @see MyBookingsController#bookMealForMe(Meal)
     */
    @Override
    public BookingToken bookMeal(final Meal meal, final CafeteriaUser booker) {
        // for pedagogical purposes: play around with the 2 approaches
        if (Application.settings().getUseEventfulControllers()) {
            return new BookAMealApplicationServiceEventfulImpl().bookMeal(meal, booker);
        } else {
            return new BookAMealApplicationServiceTransactionalImpl().bookMeal(meal, booker);
        }
    }
}
