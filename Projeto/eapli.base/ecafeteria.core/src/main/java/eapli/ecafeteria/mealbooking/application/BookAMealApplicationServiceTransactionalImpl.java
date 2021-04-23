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

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.cafeteriausermanagement.domain.CardMovement;
import eapli.ecafeteria.cafeteriausermanagement.domain.MovementBuilder;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CardMovementRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.mealbooking.domain.Booking;
import eapli.ecafeteria.mealbooking.domain.BookingService;
import eapli.ecafeteria.mealbooking.domain.BookingToken;
import eapli.ecafeteria.mealbooking.repositories.BookingRepository;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * A transactional implementation of the Application service to book a meal.
 *
 * @author Paulo Gandra Sousa
 *
 */
/* package */ class BookAMealApplicationServiceTransactionalImpl implements BookAMealApplicationService {

    private final TransactionalContext ctx = PersistenceContext.repositories().newTransactionalContext();
    private final BookingRepository bookingsRepo = PersistenceContext.repositories().bookings(ctx);
    private final CardMovementRepository movementsRepo = PersistenceContext.repositories()
            .cardMovements(ctx);
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final BookingService bookingService = new BookingService();

    /**
     *
     * @param meal
     * @param booker
     * @return
     * @see MyBookingsController#bookMealForMe(Meal)
     */
    @Override
    public BookingToken bookMeal(final Meal meal, final CafeteriaUser booker) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER, CafeteriaRoles.CAFETERIA_USER);

        // since we are implementing a transactional approach we start an ACID transaction
        ctx.beginTransaction();

        // register the booking
        Booking theBooking = bookingService.bookMeal(meal, booker, movementsRepo.balanceOf(booker.identity()));
        theBooking = bookingsRepo.save(theBooking);

        // update movements to reflect new balance
        final CardMovement mov = new MovementBuilder().cafeteriaUser(booker).purchases(theBooking.cost());
        movementsRepo.save(mov);

        // explicitly commit the transaction and save the two aggregate roots
        ctx.commit();

        return theBooking.identity();
    }
}
