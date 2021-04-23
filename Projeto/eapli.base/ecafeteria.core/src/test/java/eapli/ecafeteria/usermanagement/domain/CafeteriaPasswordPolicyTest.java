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
package eapli.ecafeteria.usermanagement.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eapli.ecafeteria.usermanagement.domain.CafeteriaPasswordPolicy.PasswordStrength;

/**
 * @author Paulo Gandra de Sousa 18/04/2020
 */
public class CafeteriaPasswordPolicyTest {

    private final CafeteriaPasswordPolicy subject = new CafeteriaPasswordPolicy();

    @Test
    public void ensurePasswordHasAtLeastOneDigitOneCapitalAnd6CharactersLong() {
        assertTrue(subject.isSatisfiedBy("abCfefgh1"));
    }

    @Test
    public void ensurePasswordsSmallerThan6CharactersAreNotAllowed() {
        assertFalse(subject.isSatisfiedBy("ab1c"));
    }

    @Test
    public void ensurePasswordsWithoutDigitsAreNotAllowed() {
        assertFalse(subject.isSatisfiedBy("abcefghi"));
    }

    @Test
    public void ensurePasswordsWithoutCapitalLetterAreNotAllowed() {
        assertFalse(subject.isSatisfiedBy("abcefghi1"));
    }

    @Test
    public void testWeakPassword1() {
        assertEquals(PasswordStrength.WEAK, subject.strength("A23456"));
    }

    @Test
    public void testWeakPassword2() {
        assertEquals(PasswordStrength.WEAK, subject.strength("A234567"));
    }

    @Test
    public void testGoodPassword1() {
        assertEquals(PasswordStrength.GOOD, subject.strength("A2345678"));
    }

    @Test
    public void testGoodPassword2() {
        assertEquals(PasswordStrength.GOOD, subject.strength("A23456789"));
    }

    @Test
    public void testExcelentPassword1() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("123456789ABC"));
    }

    @Test
    public void testExcelentPassword2() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("123456789ABCD"));
    }

    @Test
    public void testExcelentPassword3() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("A234$5678"));
    }

    @Test
    public void testExcelentPassword4() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("A234#5678"));
    }

    @Test
    public void testExcelentPassword5() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("A234!5678"));
    }

    @Test
    public void testExcelentPassword6() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("A234?5678"));
    }
}
