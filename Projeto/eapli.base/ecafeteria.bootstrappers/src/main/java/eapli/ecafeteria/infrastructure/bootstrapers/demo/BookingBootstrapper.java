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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.cafeteriausermanagement.domain.MecanographicNumber;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CafeteriaUserRepository;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CardMovementRepository;
import eapli.ecafeteria.infrastructure.bootstrapers.TestDataConstants;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.mealbooking.application.BookAMealForADayController;
import eapli.ecafeteria.mealbooking.application.BookAMealForADayControllerImpl;
import eapli.ecafeteria.mealbooking.domain.BookingToken;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.repositories.MealRepository;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Money;
import eapli.framework.validations.Invariants;

/**
 *
 * @author Paulo Gandra de Sousa
 *
 */
public class BookingBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(BookingBootstrapper.class);

    private final BookAMealForADayController controller = new BookAMealForADayControllerImpl();
    private final MealRepository mealRepo = PersistenceContext.repositories().meals();
    private final CafeteriaUserRepository userRepo = PersistenceContext.repositories()
            .cafeteriaUsers();
    private final CardMovementRepository movementsRepo = PersistenceContext.repositories()
            .cardMovements();

    private final List<BookingToken> tokens = new ArrayList<>();

    public List<BookingToken> bookings() {
        return tokens;
    }

    @Override
    public boolean execute() {

        final BookingToken token = book(TestDataConstants.USER_TEST1, TestDataConstants.DATE_TO_BOOK);
        if (token == null) {
            return false;
        }

        tokens.add(token);

        return true;
    }

    private BookingToken book(final String number, final Calendar when) {
        final Meal meal = mealRepo.findByDayAndType(when, TestDataConstants.MEAL_TYPE_TO_BOOK).iterator()
                .next();
        final CafeteriaUser booker = userRepo.ofIdentity(MecanographicNumber.valueOf(number))
                .orElseThrow(IllegalStateException::new);
        try {
            final Money currentBalance = movementsRepo.balanceOf(booker.mecanographicNumber());

            final BookingToken token = controller.bookMeal(meal, booker);
            LOGGER.debug("Booked meal {} for user {} with token {}", meal, booker, token);

            // assert the booking has been registered
            // since we are using events, the balance might not yet be updated, so lets give it a
            // time and wait
            Thread.sleep(1000);
            final Money newBalance = movementsRepo.balanceOf(booker.mecanographicNumber());
            Invariants.ensure(newBalance.equals(currentBalance.subtract(meal.dish().currentPrice())),
                    "Balance has not been properly updated when booking");

            return token;
        } catch (IntegrityViolationException | ConcurrencyException | InterruptedException e) {
            LOGGER.error("While booking a meal for user {}", number, e);
            // Restore interrupted state...
            Thread.currentThread().interrupt();
            return null;
        }
    }
}
