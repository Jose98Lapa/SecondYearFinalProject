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
package eapli.ecafeteria.mealbooking.domain;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.framework.domain.services.DomainService;
import eapli.framework.general.domain.model.Money;
import eapli.framework.time.util.CalendarPredicates;
import eapli.framework.time.util.Calendars;

/**
 * The domain service to book meals.
 * <p>
 * This domain service isolates the business rules. The application services must "inject" all the
 * needed dependencies.
 *
 * @author Paulo Gandra Sousa 2021.03.23
 *
 */
@DomainService
public class BookingService {

    /**
     *
     * @param meal
     * @param booker
     * @return
     */
    public Booking bookMeal(final Meal meal, final CafeteriaUser booker, final Money balance) {

        if (!canBook(meal, booker, balance)) {
            // TODO do not use exceptions for application flow control
            throw new IllegalStateException("Insufficient funds");
        }

        return new Booking(booker, meal);
    }

    /**
     * Check if the user can book this meal. The rules could be quite complex in the
     * future and allow for overdraft or entitlement for free meals (e.g., scholarship).
     *
     * @param meal
     * @param booker
     * @return
     */
    private boolean canBook(final Meal meal, @SuppressWarnings("java:S1172") final CafeteriaUser booker,
            final Money balance) {
        return mealIsInTheFuture(meal) && hasEnoughBalance(meal, balance);
    }

    /**
     * @param meal
     * @return
     */
    private boolean mealIsInTheFuture(final Meal meal) {
        return CalendarPredicates.isAfter(meal.day(), Calendars.now());
    }

    /**
     * Check user card's balance prior to booking the meal.
     *
     * @param meal
     * @return
     */
    private boolean hasEnoughBalance(final Meal meal, final Money balance) {
        final Money price = meal.dish().currentPrice();
        return balance.isGreaterThanOrEqual(price);
    }
}
