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
package eapli.ecafeteria.sales.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Money;
import eapli.framework.validations.Preconditions;

/**
 * TODO the info about which POS or worksession the charge was done is missing
 *
 * @author mcn
 */
@Entity
public class CreditRecharge implements AggregateRoot<Long> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue // (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CafeteriaUser cafeteriaUser;

    private Money ammount;

    @Temporal(TemporalType.DATE)
    private Calendar occurredOn;

    protected CreditRecharge() {
        // only for ORM
    }

    public CreditRecharge(final CafeteriaUser cafeteriaUser, final Money ammount) {
        this(cafeteriaUser, ammount, Calendar.getInstance());
    }

    public CreditRecharge(final CafeteriaUser cafeteriaUser, final Money ammount,
            final Calendar occurredOn) {
        Preconditions.noneNull(cafeteriaUser, ammount, occurredOn);

        this.cafeteriaUser = cafeteriaUser;
        this.ammount = ammount;
        this.occurredOn = occurredOn;
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof CreditRecharge)) {
            return false;
        }
        if (this == other) {
            return true;
        }

        final CreditRecharge that = (CreditRecharge) other;
        return identity().equals(that.identity()) && ammount.equals(that.ammount)
                && cafeteriaUser.equals(that.cafeteriaUser) && occurredOn.equals(that.occurredOn);
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
    public Long identity() {
        return id;
    }
}
