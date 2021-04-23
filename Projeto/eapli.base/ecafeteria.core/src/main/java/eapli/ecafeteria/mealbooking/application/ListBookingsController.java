/*
 * Copyright (c) 2013-2020 the original author or authors.
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

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.mealbooking.domain.Booking;
import eapli.ecafeteria.mealbooking.repositories.BookingRepository;
import eapli.ecafeteria.mealmanagement.domain.MealType;

/**
 *
 * @author Paulo Gandra de Sousa
 */
public class ListBookingsController {

    private final BookingRepository repo = PersistenceContext.repositories().bookings();

    public Iterable<Booking> bookingsOf(final CafeteriaUser who) {
        return repo.findByUser(who);
    }

    public Iterable<Booking> bookingsOf(final Calendar day, final MealType type) {
        return repo.findByCafe(day, type);
    }
}
