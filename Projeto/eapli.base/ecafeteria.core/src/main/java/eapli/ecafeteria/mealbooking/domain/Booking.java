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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Invariants;
import eapli.framework.validations.Preconditions;

/**
 * A meal booking of a user.
 *
 * @author Paulo Gandra Sousa
 *
 */
@Entity
public class Booking implements AggregateRoot<BookingToken> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue // (strategy = GenerationType.IDENTITY)
    private Long pk;

    @Version
    private Long version;

    // business id
    @Column(unique = true, nullable = false)
    private BookingToken token;

    @ManyToOne()
    private CafeteriaUser user;

    @ManyToOne()
    private Meal meal;

    private BookingStatus status;

    private Money cost;

    @OneToMany(cascade = CascadeType.ALL)
    private final Set<AbstractBookingEvent> events = new HashSet<>();

    protected Booking() {
        // for ORM
    }

    public Booking(final CafeteriaUser user, final Meal what) {
        Preconditions.noneNull(user, what);

        this.user = user;
        meal = what;
        cost = meal.dish().currentPrice();

        token = BookingToken.newToken();

        final BookedEvent booked = new BookedEvent(this);
        events.add(booked);
        status = BookingStatus.BOOKED;
    }

    /**
     *
     * @return how much this meal has costed
     */
    public Money cost() {
        return cost;
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Booking)) {
            return false;
        }
        final Booking that = (Booking) other;
        return new EqualsBuilder().append(user, that.user).append(meal, that.meal)
                .append(token, that.token).append(events, that.events).append(status, that.status)
                .isEquals();
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public BookingToken identity() {
        return token;
    }

    public BookingStatus status() {
        return status;
    }

    public boolean isBooked() {
        return status() == BookingStatus.BOOKED;
    }

    public boolean isCanceled() {
        return status() == BookingStatus.CANCELED;
    }

    public boolean isDelivered() {
        return status() == BookingStatus.DELIVERED;
    }

    public boolean isUndelivered() {
        return status() == BookingStatus.UNDELIVERED;
    }

    public Meal meal() {
        return meal;
    }

    public DeliveredEvent deliver(final SystemUser cashier) {
        Invariants.ensure(status == BookingStatus.BOOKED,
                "A booking can only be delivered if currently booked");

        status = BookingStatus.DELIVERED;
        final DeliveredEvent delivered = new DeliveredEvent(this, cashier);
        events.add(delivered);
        return delivered;
    }

    public Set<AbstractBookingEvent> history() {
        return Collections.unmodifiableSet(events);
    }

    public CafeteriaUser user() {
        return user;
    }
}
