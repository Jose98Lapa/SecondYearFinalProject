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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author AntónioRocha
 */
public class NutricionalInfoTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCaloriesMustNotBeNegative() {
        System.out.println("calories must not be negative");
        new NutricionalInfo(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaltMustNotBeNegative() {
        System.out.println("Salt must not be negative");
        new NutricionalInfo(0, -6);
    }

    @Test
    public void testCalories() {
        System.out.println("calories");
        final NutricionalInfo instance = new NutricionalInfo(3, 5);
        assertEquals(3, instance.calories());
    }

    @Test
    public void testSalt() {
        System.out.println("calories");
        final NutricionalInfo instance = new NutricionalInfo(3, 5);
        assertEquals(5, instance.salt());
    }
}
