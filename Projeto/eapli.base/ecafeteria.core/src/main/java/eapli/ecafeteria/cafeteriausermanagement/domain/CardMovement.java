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
package eapli.ecafeteria.cafeteriausermanagement.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Money;
import eapli.framework.validations.Preconditions;

/**
 * One movement of a user card.
 * <p>
 * As there can be a large number of movements for each cafeteria user (for instance, one that eats
 * at the cafeteria every day of the semester) CardMovements are better as their own aggregate
 * instead of an entity part of the CafeteriaUser aggregate.
 * This poses the question "How can one know the balance of a card?".
 * <p>
 * Since a {@link CardMovement} is an aggregate we need to have a place to actually calculate
 * the balance summing up all the movements. The
 * {@link eapli.ecafeteria.cafeteriausermanagement.repositories.CardMovementRepository
 * CardMovementRepository} is a natural place for such
 * operations in a DDD world as the repository is a domain-level interface (not to be confounded
 * with the repository's implementation).
 * <p>
 * Due to performance reasons, old movements could be archived after some period and a "snapshot"
 * balance movement be created.
 *
 * @author mcn
 */
@Entity
public class CardMovement implements AggregateRoot<Long> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue // (strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MovementType type;

    private Money amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private CafeteriaUser user;

    @Temporal(TemporalType.DATE)
    private Calendar occurredOn;

    protected CardMovement() {
        // for ORM tool only
    }

    public CardMovement(final MovementType type, final Money ammount,
            final CafeteriaUser userCard) {
        this(type, ammount, userCard, Calendar.getInstance());
    }

    public CardMovement(final MovementType type, final Money amount, final CafeteriaUser user,
            final Calendar dateOccurrence) {
        Preconditions.noneNull(type, amount, user, dateOccurrence);

        this.type = type;
        if (type == MovementType.PURCHASE && !amount.isNegative()) {
            this.amount = amount.negate();
        } else {
            this.amount = amount;
        }
        this.user = user;
        occurredOn = dateOccurrence;
    }

    public CafeteriaUser account() {
        return user;
    }

    public MovementType movementType() {
        return type;
    }

    public Calendar occurredOn() {
        return occurredOn;
    }

    public Money amount() {
        return amount;
    }

    public Money accountingValue() {
        return type == MovementType.PURCHASE ? amount.negate() : amount;
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
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return id;
    }
}
