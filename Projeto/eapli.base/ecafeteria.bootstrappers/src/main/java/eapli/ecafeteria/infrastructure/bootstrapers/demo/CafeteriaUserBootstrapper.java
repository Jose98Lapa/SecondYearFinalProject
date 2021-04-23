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
package eapli.ecafeteria.infrastructure.bootstrapers.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecafeteria.cafeteriausermanagement.application.AcceptRefuseSignupFactory;
import eapli.ecafeteria.cafeteriausermanagement.application.AcceptRefuseSignupRequestController;
import eapli.ecafeteria.cafeteriausermanagement.application.AcceptRefuseSignupRequestControllerEventfulImpl;
import eapli.ecafeteria.cafeteriausermanagement.application.AcceptRefuseSignupRequestControllerTxImpl;
import eapli.ecafeteria.cafeteriausermanagement.domain.SignupRequest;
import eapli.ecafeteria.infrastructure.bootstrapers.TestDataConstants;
import eapli.ecafeteria.mycafeteriauser.application.SignupController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

/**
 * Bootstrapper that demonstrates how a Cafeteria User can be added to the
 * system.
 * <p>
 * If application property {@code UseEventfulControllers} is set to {@code false}, than the
 * {@link AcceptRefuseSignupRequestController} uses an fully transactional (eventless) controller
 * {@link AcceptRefuseSignupRequestControllerTxImpl}.
 * <p>
 * If application property {@code UseEventfulControllers} is set to {@code true}, than the
 * {@link AcceptRefuseSignupRequestController} uses an eventful controller
 * {@link AcceptRefuseSignupRequestControllerEventfulImpl}.
 *
 * @author Paulo Sousa
 */
public class CafeteriaUserBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(CafeteriaUserBootstrapper.class);

    private final SignupController signupController = new SignupController();
    private final AcceptRefuseSignupRequestController acceptController = AcceptRefuseSignupFactory.build();

    @Override
    public boolean execute() {
        signupAndApprove(TestDataConstants.USER_TEST1, "Password1", "John", "Smith", "john@smith.com",
                TestDataConstants.USER_TEST1);
        signupAndApprove("isep959", "Password1", "Mary", "Smith", "mary@smith.com", "isep959");
        return true;
    }

    private SignupRequest signupAndApprove(final String username, final String password, final String firstName,
            final String lastName, final String email, final String mecanographicNumber) {
        SignupRequest request = null;
        try {
            request = signupController.signup(username, password, firstName, lastName, email, mecanographicNumber);
            acceptController.acceptSignupRequest(request);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", username);
            LOGGER.trace("Assuming existing record", e);
        }
        return request;
    }
}
