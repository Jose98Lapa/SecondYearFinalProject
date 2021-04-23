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
import eapli.ecafeteria.cafeteriausermanagement.repositories.CardMovementRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.mealbooking.domain.BookedEvent;
import eapli.ecafeteria.mealbooking.domain.Booking;
import eapli.ecafeteria.mealbooking.domain.BookingService;
import eapli.ecafeteria.mealbooking.domain.BookingToken;
import eapli.ecafeteria.mealbooking.repositories.BookingRepository;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.eventpubsub.EventPublisher;
import eapli.framework.infrastructure.eventpubsub.impl.inprocess.InProcessPubSub;

/**
 * An eventful implementation of the Application service to book a meal.
 *
 * @author Paulo Gandra de Sousa 2021.03.16
 *
 */
class BookAMealApplicationServiceEventfulImpl implements BookAMealApplicationService {

    private final BookingRepository bookingsRepo = PersistenceContext.repositories().bookings();
    private final CardMovementRepository movementsRepo = PersistenceContext.repositories().cardMovements();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final EventPublisher dispatcher = InProcessPubSub.publisher();
    private final BookingService bookingService = new BookingService();

    @Override
    public BookingToken bookMeal(final Meal meal, final CafeteriaUser booker) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER, CafeteriaRoles.CAFETERIA_USER);

        Booking theBooking = bookingService.bookMeal(meal, booker, movementsRepo.balanceOf(booker.identity()));
        theBooking = bookingsRepo.save(theBooking);

        // publish event, notify interested parties (if any)
        // TODO should we use the persistent event class or publish a different one?
        final DomainEvent event = new BookedEvent(theBooking);
        dispatcher.publish(event);

        return theBooking.identity();
    }

}
