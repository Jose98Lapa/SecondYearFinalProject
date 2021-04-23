/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and
 * associated documentation files (the "Software"), to deal in the Software
 * without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish,
 * distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.ecafeteria.mealbooking.application;

import java.util.Calendar;
import java.util.Optional;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CafeteriaUserRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.mealbooking.domain.Booking;
import eapli.ecafeteria.mealbooking.domain.BookingToken;
import eapli.ecafeteria.mealbooking.repositories.BookingRepository;
import eapli.ecafeteria.mealmanagement.application.ListMealService;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.domain.MealType;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author Paulo Gandra de Sousa
 *
 */
public class MyBookingsController {

    private final BookingRepository bookingsRepo = PersistenceContext.repositories().bookings();
    private final CafeteriaUserRepository userRepo = PersistenceContext.repositories().cafeteriaUsers();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListMealService svcMeals = new ListMealService();

    /**
     * Returns the bookings of the authenticated cafeteria user.
     *
     * @return the bookings of the authenticated cafeteria user
     */
    public Iterable<Booking> myBookings() {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.CAFETERIA_USER);

        // TODO it would be more efficient to avoid going back to the DB twice
        // to have a finder method in the booking repository that could search
        // by username
        return currentUser().map(bookingsRepo::findByUser).orElseThrow(IllegalStateException::new);
    }

    private Optional<CafeteriaUser> currentUser() {
        return authz.session()
                .flatMap(s -> userRepo.findByUsername(s.authenticatedUser().username()));
    }

    public Iterable<Meal> allMealsByDateAndType(final Calendar theDay, final MealType mealType) {
        return svcMeals.mealsByDayAndType(theDay, mealType);
    }

    /**
     *
     * @param theDay
     * @param mealType
     * @return
     */
    public Optional<Booking> iAlreadyHaveABooking(final Calendar theDay, final MealType mealType) {
        final CafeteriaUser user = currentUser().orElseThrow(IllegalStateException::new);
        return bookingsRepo.findByUserForADayAndMealType(user, theDay, mealType);
    }

    /**
     *
     * @param meal
     * @return
     * @see BookAMealForADayController#bookMeal(Meal, CafeteriaUser)
     */
    public BookingToken bookMealForMe(final Meal meal) {
        return new BookAMealForADayControllerImpl().bookMeal(meal,
                currentUser().orElseThrow(IllegalStateException::new));
    }
}
