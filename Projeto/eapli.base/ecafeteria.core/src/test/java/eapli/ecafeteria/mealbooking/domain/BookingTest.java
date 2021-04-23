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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.cafeteriausermanagement.domain.MecanographicNumber;
import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.domain.MealType;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.time.util.Calendars;

/**
 *
 * @author Paulo Gandra de Sousa 2021.03.23
 *
 */
class BookingTest {
    private final DishType aDishType = new DishType("fish", "fish");
    private final Money aPrice = Money.euros(123);
    private final Dish aDish = new Dish(aDishType, Designation.valueOf("Braised Cod"), aPrice);
    private final Meal aMeal = new Meal(MealType.LUNCH, Calendars.now(), aDish);
    private CafeteriaUser aUser;

    @BeforeAll
    void setup() {
        final SystemUser s = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder())
                .with("userName", "password", "firstName", "lastName", "email@acme.com")
                .build();
        new CafeteriaUser(s, MecanographicNumber.valueOf("102030"));
    }

    @Test
    void ensureBookingHasMeal() {
        assertThrows(IllegalArgumentException.class, () -> new Booking(aUser, null));
    }

    @Test
    void ensureBookingHasUser() {
        assertThrows(IllegalArgumentException.class, () -> new Booking(null, aMeal));
    }

    @Test
    void ensureBookingHasToken() {
        final Booking b = new Booking(aUser, aMeal);
        assertTrue(b.identity() != null);
    }

    @Test
    void ensureCostIsCurrentDishPrice() {
        final Booking subject = new Booking(aUser, aMeal);

        assertEquals(subject.cost(), aDish.currentPrice());
    }
}
