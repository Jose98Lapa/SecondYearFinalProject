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
package eapli.ecafeteria.persistence.impl.jpa;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.ecafeteria.Application;
import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.mealbooking.domain.Booking;
import eapli.ecafeteria.mealbooking.domain.BookingToken;
import eapli.ecafeteria.mealbooking.repositories.BookingRepository;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.domain.MealType;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public class JpaBookingRepository extends JpaAutoTxRepository<Booking, Long, BookingToken>
        implements BookingRepository {

    public JpaBookingRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaBookingRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<Booking> findByUser(final CafeteriaUser who) {
        final Map<String, Object> params = new HashMap<>();
        params.put("user", who);
        return match("e.user = :user", params);
    }

    @Override
    public Iterable<Booking> findByMeal(final Meal what) {
        final Map<String, Object> params = new HashMap<>();
        params.put("what", what);
        return match("e.meal = :what", params);
    }

    @Override
    public Iterable<Booking> findByCafe(final Calendar day, final MealType type) {
        final Map<String, Object> params = new HashMap<>();

        params.put("day", day);
        params.put("type", type);

        return match("e.meal.day = :day AND e.meal.mealType = :type", params);
    }

    @Override
    public Optional<Booking> findByUserForADayAndMealType(final CafeteriaUser user, final Calendar day,
            final MealType mealType) {
        final Map<String, Object> params = new HashMap<>();
        params.put("user", user);
        params.put("day", day);
        params.put("type", mealType);
        return matchOne("e.user = :user AND e.meal.day = :day AND e.meal.mealType = :type", params);
    }
}
