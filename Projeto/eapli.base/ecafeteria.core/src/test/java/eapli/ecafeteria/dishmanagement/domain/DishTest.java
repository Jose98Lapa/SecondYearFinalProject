/*
 * Copyright (c) 2013-2020 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.ecafeteria.dishmanagement.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.Money;

/**
 * @author Paulo Gandra Sousa
 *
 */
public class DishTest {

    private static final Designation BACALHAU_NAME = Designation.valueOf("Bacalhau");
    private static final DishType FISH_DISH_TYPE = new DishType("fish", "fish");

    /**
     * Test method for
     * {@link eapli.ecafeteria.dishmanagement.domain.model.Dish#Dish(eapli.ecafeteria.dishmanagement.domain.model.DishType, eapli.framework.domain.model.general.Designation, eapli.ecafeteria.dishmanagement.domain.model.NutricionalInfo, eapli.framework.domain.model.general.Money)}.
     */
    @Test
    public void ensureDishWithDishTypeDesignationAndPrice() {
        new Dish(FISH_DISH_TYPE, BACALHAU_NAME, Money.euros(1.0));
        assertTrue(true);
    }

    @Test
    public void ensureDishWithDishTypeDesignationPriceAndNutricionalInfo() {
        new Dish(FISH_DISH_TYPE, BACALHAU_NAME, new NutricionalInfo(1, 1), Money.euros(1.0));
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDishWithNutricionalInfoMustNotBeNull() {
        new Dish(FISH_DISH_TYPE, BACALHAU_NAME, null, Money.euros(1.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveDishType() {
        new Dish(null, BACALHAU_NAME, Money.euros(1.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveDesignation() {
        new Dish(FISH_DISH_TYPE, null, Money.euros(1.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHavePrice() {
        new Dish(FISH_DISH_TYPE, BACALHAU_NAME, null);
    }

    /**
     * Test of changeNutricionalInfoTo method, of class Dish.
     *
     * PRP - 29.mar.2017
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureCannotChangeNutricionalInfoToNull() {
        System.out.println("ChangeNutricionalInfoTo -New nutricional info must not be null");

        final Dish subject = new Dish(FISH_DISH_TYPE, BACALHAU_NAME, new NutricionalInfo(1, 1),
                Money.euros(7));
        subject.changeNutricionalInfoTo(null);
    }

    /**
     * Tests of changePriceTo method, of class Dish.
     *
     * PRP - 29.mar.2017
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureCannotChangePriceToNull() {
        System.out.println("ChangePriceTo -New price info must not be null");

        final Dish subject = new Dish(FISH_DISH_TYPE, BACALHAU_NAME, new NutricionalInfo(1, 1),
                Money.euros(7));
        subject.changePriceTo(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCannotChangePriceToNegative() {
        System.out.println("ChangePriceTo -New price can nt be negativel");

        final Dish subject = new Dish(FISH_DISH_TYPE, BACALHAU_NAME, new NutricionalInfo(1, 1),
                Money.euros(1));
        subject.changePriceTo(Money.euros(-1));
    }
}
