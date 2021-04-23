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
package eapli.ecafeteria.app.user.console.presentation.mybookings;

import java.util.Calendar;
import java.util.Optional;

import eapli.ecafeteria.app.user.console.presentation.CafeteriaUserBaseUI;
import eapli.ecafeteria.mealbooking.application.MyBookingsController;
import eapli.ecafeteria.mealbooking.domain.Booking;
import eapli.ecafeteria.mealbooking.domain.BookingToken;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.domain.MealType;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.time.util.Calendars;

/**
 *
 * @author mcn 2018.05.14
 * @author Paulo Gandra de Sousa 2021.03.31
 */
@SuppressWarnings({ "squid:S106" })
public class RegisterBookingUI extends CafeteriaUserBaseUI {

    private final MyBookingsController theController = new MyBookingsController();

    @Override
    protected boolean doShow() {

        final Calendar theDay = selectValidDate();
        final MealType mealType = selectMealType();

        final Optional<Booking> booking = theController.iAlreadyHaveABooking(theDay, mealType);
        booking.ifPresentOrElse(
                b -> System.out.println("You already have a booking for this date and meal type"),
                () -> selectMealAndBook(theDay, mealType));
        return false;
    }

    private void selectMealAndBook(final Calendar theDay, final MealType mealType) {
        final Meal theMeal = selectPublishedMealsForDayAndType(theDay, mealType);
        if (theMeal != null) {
            try {
                final BookingToken token = theController.bookMealForMe(theMeal);
                if (token != null) {
                    System.out.println("SUCCESS. Your token is " + token);
                } else {
                    System.out.println("It was not possible to make your booking");
                }
            } catch (final ConcurrencyException e) {
                System.out.println("Problems with Data integrity");
            }
        }
    }

    private MealType selectMealType() {

        System.out.println("Meal Types Available:");
        for (final MealType type : MealType.values()) {
            System.out.println("\t" + type);
        }

        do {
            try {
                final String type = Console.readLine("Meal Type?");
                return MealType.valueOf(type);
            } catch (final IllegalArgumentException e) {
                System.out.println("Please try again. enter a valid meal type.");
            }
        } while (true);
    }

    // TODO Date should be 12 h
    private Calendar selectValidDate() {
        Calendar theDay;

        System.out.println("Please enter a date in the future");
        do {
            theDay = Console.readCalendar("Meal Date (yyyy-MM-dd):", "yyyy-MM-dd");
            System.out.println("TRACE: " + Calendars.format(theDay));
        } while (!theDay.after(Calendars.now()));
        return theDay;
    }

    private Meal selectPublishedMealsForDayAndType(final Calendar theDay, final MealType mealType) {
        final Iterable<Meal> meals = theController.allMealsByDateAndType(theDay, mealType);
        final SelectWidget<Meal> selector = new SelectWidget<>("Available Meals:", meals, new MealPrinter());
        selector.show();
        return selector.selectedElement();
    }
}
