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
package eapli.ecafeteria.mealmanagement.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.time.util.Calendars;
import eapli.framework.validations.Preconditions;

/**
 * A meal.
 *
 * @author Paulo Gandra Sousa
 *
 */
@Entity
public class Meal implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @Temporal(TemporalType.DATE)
    private Calendar day;

    @ManyToOne
    private Dish dish;

    protected Meal() {
        // for ORM
    }

    public Meal(final MealType mealType, final Calendar ofDay, final Dish dish) {
        Preconditions.noneNull(mealType, ofDay, dish);

        this.mealType = mealType;
        day = ofDay;
        this.dish = dish;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    public MealType mealType() {
        return mealType;
    }

    public Dish dish() {
        return dish;
    }

    public Calendar day() {
        return day;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Meal)) {
            return false;
        }

        final Meal that = (Meal) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
        // FIXME compare other fields
    }

    @Override
    public String toString() {
        return dish + " @ " + Calendars.format(day) + " / " + mealType;
    }
}
