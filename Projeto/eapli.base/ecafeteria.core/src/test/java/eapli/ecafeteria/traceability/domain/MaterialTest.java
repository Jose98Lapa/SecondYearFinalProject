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
package eapli.ecafeteria.traceability.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 * @author mcn
 */
public class MaterialTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureAcronymMustNotBeEmpty() {
        System.out.println("must have non-empty acronym");
        new Material("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAcronymMustNotBeNull() {
        System.out.println("must have an acronym");
        new Material(null, "");
    }

    @Test
    public void testChangeDescriptionTo() {
        System.out.println("changeDescriptionTo");
        final Material instance = new Material("eggs", "Eggs (chicken, duck)");
        final String newDescription = "new description";
        instance.changeDescriptionTo(newDescription);
        assertEquals(newDescription, instance.description());
    }

    /**
     * Test of id method, of class DishType.
     */
    @Test
    public void testId() {
        System.out.println("id");
        final String acronym = "eggs";
        final Material instance = new Material(acronym, "real eggs");
        assertEquals(acronym, instance.identity());
    }

    /**
     * Test of is method, of class DishType.
     */
    @Test
    public void testIs() {
        System.out.println("Test is method");
        final String id = "eggs";
        final Material instance = new Material(id, "real eggs");
        assertTrue(instance.hasIdentity(id));
    }
}
