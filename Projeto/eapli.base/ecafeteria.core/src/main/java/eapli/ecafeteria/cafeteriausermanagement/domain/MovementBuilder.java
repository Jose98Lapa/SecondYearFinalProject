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
package eapli.ecafeteria.cafeteriausermanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Money;
import eapli.framework.validations.Preconditions;

/**
 * A factory for Movements.
 * <p>
 * This class demonstrates the use of the factory (DDD) pattern using a fluent
 * interface. it acts as a Builder (GoF).
 *
 * @author Paulo Proença prp@isep.ipp.pt
 */
public class MovementBuilder implements DomainFactory<CardMovement> {

    private MovementType type;
    private Money value;
    private CafeteriaUser cafeteriaUser;

    /**
     * Chainable builder method for defining the cafeteria user of the movement to build.
     *
     * @param cafeteriaUser
     * @return
     */
    public MovementBuilder cafeteriaUser(final CafeteriaUser cafeteriaUser) {
        Preconditions.nonNull(cafeteriaUser);

        this.cafeteriaUser = cafeteriaUser;
        return this;
    }

    /**
     * Builds a Purchase movement.
     *
     * @param value
     * @return a Purchase movement
     */
    public CardMovement purchases(final Money value) {
        Preconditions.ensure(value != null && value.isGreaterThan(Money.euros(0)));

        return withType(MovementType.PURCHASE).withValue(value).build();
    }

    /**
     * Builds a recharge movement.
     *
     * @param value
     * @return a recharge movement
     */
    public CardMovement recharges(final Money value) {
        Preconditions.ensure(value != null && value.isGreaterThan(Money.euros(0)));

        return withType(MovementType.RECHARGE).withValue(value).build();
    }

    /**
     * Chainable builder method for defining the type of the movement to build.
     *
     * @param type
     * @return
     */
    public MovementBuilder withType(final MovementType type) {
        Preconditions.nonNull(type);

        this.type = type;
        return this;
    }

    /**
     * Chainable builder method for defining the amount of the movement to build.
     * 
     * @param value
     * @return
     */
    public MovementBuilder withValue(final Money value) {
        Preconditions.ensure(value != null && value.isGreaterThan(Money.euros(0)));

        this.value = value;
        return this;
    }

    @Override
    public CardMovement build() {
        return new CardMovement(type, value, cafeteriaUser);
    }
}
