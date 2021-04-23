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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;

/**
 * Created by Nuno Bettencourt [NMB] on 03/04/16.
 */
public class CafeteriaUserTest {

    private final String aMecanographicNumber = "abc";
    private final String anotherMecanographicNumber = "xyz";

    public static SystemUser dummyUser(final String username, final Role... roles) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(),
                new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles)
                .build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", CafeteriaRoles.ADMIN);
    }

    @Test
    public void ensureCafeteriaUserEqualsPassesForTheSameMecanographicNumber() throws Exception {

        final CafeteriaUser aCafeteriaUser = new CafeteriaUserBuilder()
                .withMecanographicNumber("DUMMY").withSystemUser(getNewDummyUser()).build();

        final CafeteriaUser anotherCafeteriaUser = new CafeteriaUserBuilder()
                .withMecanographicNumber("DUMMY").withSystemUser(getNewDummyUser()).build();

        final boolean expected = aCafeteriaUser.equals(anotherCafeteriaUser);

        assertTrue(expected);
    }

    @Test
    public void ensureCafeteriaUserEqualsFailsForDifferenteMecanographicNumber() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(CafeteriaRoles.ADMIN);

        final CafeteriaUser aCafeteriaUser = new CafeteriaUserBuilder()
                .withMecanographicNumber(aMecanographicNumber).withSystemUser(getNewDummyUser())
                .build();

        final CafeteriaUser anotherCafeteriaUser = new CafeteriaUserBuilder()
                .withMecanographicNumber(anotherMecanographicNumber)
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aCafeteriaUser.equals(anotherCafeteriaUser);

        assertFalse(expected);
    }

    @Test
    public void ensureCafeteriaUserEqualsAreTheSameForTheSameInstance() throws Exception {
        final CafeteriaUser aCafeteriaUser = new CafeteriaUser();

        final boolean expected = aCafeteriaUser.equals(aCafeteriaUser);

        assertTrue(expected);
    }

    @Test
    public void ensureCafeteriaUserEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(CafeteriaRoles.ADMIN);

        final CafeteriaUser aCafeteriaUser = new CafeteriaUserBuilder()
                .withMecanographicNumber("DUMMY").withSystemUser(getNewDummyUser()).build();

        @SuppressWarnings("unlikely-arg-type")
        final boolean expected = aCafeteriaUser.equals(getNewDummyUser());

        assertFalse(expected);
    }

    @Test
    public void ensureCafeteriaUserIsTheSameAsItsInstance() throws Exception {
        final CafeteriaUser aCafeteriaUser = new CafeteriaUserBuilder()
                .withMecanographicNumber("DUMMY").withSystemUser(getNewDummyUser()).build();

        final boolean expected = aCafeteriaUser.sameAs(aCafeteriaUser);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoCafeteriaUserWithDifferentMecanographicNumbersAreNotTheSame()
            throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(CafeteriaRoles.ADMIN);
        final CafeteriaUser aCafeteriaUser = new CafeteriaUserBuilder()
                .withMecanographicNumber(aMecanographicNumber).withSystemUser(getNewDummyUser())
                .build();

        final CafeteriaUser anotherCafeteriaUser = new CafeteriaUserBuilder()
                .withMecanographicNumber(anotherMecanographicNumber)
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aCafeteriaUser.sameAs(anotherCafeteriaUser);

        assertFalse(expected);
    }
}
