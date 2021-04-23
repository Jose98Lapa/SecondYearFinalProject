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
package eapli.ecafeteria.dishmanagement.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 * @author mcn
 */
public class DishTypeTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureAcronymMustNotBeEmpty() {
        System.out.println("must have non-empty acronym");
        new DishType("", "vegetarian dish");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAcronymMustNotBeNull() {
        System.out.println("must have an acronym");
        new DishType(null, "vegetarian dish");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionMustNotBeEmpty() {
        System.out.println("must have non-empty description");
        new DishType("veg1", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionMustNotBeNull() {
        System.out.println("must have a description");
        new DishType("veg1", null);
    }

    @Test
    public void ensureCreatedDishTypeIsActive() {
        final String acronym = "vege001";
        final DishType instance = new DishType(acronym, "vegetarian dish");
        assertTrue(instance.isActive());
    }

    /**
     * Test of changeDishTypeState method, of class DishType.
     */
    @Test
    public void testChangeDishTypeState() {
        System.out.println("changeDishTypeState");
        final DishType instance = new DishType("vege005", "vegetarian dish");
        instance.toogleState();
        final boolean expResult = false;
        final boolean result = instance.isActive();
        assertEquals(expResult, result);
    }

    /**
     * Test of changeDescriptionTo method, of class DishType.
     */

    @Test(expected = IllegalArgumentException.class)
    public void ensureCannotChangeDescriptionToNull() {
        System.out.println("ChangeDescriptionTo -New description must not be null");
        final DishType instance = new DishType("vege005", "vegetarian dish");
        instance.changeDescriptionTo(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCannotChangeDescriptionToEmpty() {
        System.out.println("ChangeDescriptionTo -New description must not be empty");
        final DishType instance = new DishType("vege005", "vegetarian dish");
        instance.changeDescriptionTo("");
    }

    @Test
    public void testChangeDescriptionTo() {
        System.out.println("attest changeDescriptionTo");
        final DishType instance = new DishType("vege005", "vegetarian dish");
        final String newDescription = "new description";
        instance.changeDescriptionTo(newDescription);
        final String expResult = newDescription;
        final String result = instance.description();
        assertEquals(expResult, result);
    }

    @Test
    public void ensureDishTypeCreatedWitnAnIdentityHasThatIdentity() {
        System.out.println("ensureDishTypeCreatedWitnAnIdentityHasThatIdentity - identity()");
        final String acronym = "veg";
        final DishType instance = new DishType(acronym, "vegetarian dish");
        assertEquals(acronym, instance.identity());
    }

    @Test
    public void ensureDishTypeCreatedWitnAnIdentityHasThatIdentity2() {
        System.out.println("ensureDishTypeCreatedWitnAnIdentityHasThatIdentity - hasIdentity");
        final String id = "veg";
        final String description = "vegetarian dish";
        final DishType instance = new DishType(id, description);
        assertTrue(instance.hasIdentity(id));
    }
}
