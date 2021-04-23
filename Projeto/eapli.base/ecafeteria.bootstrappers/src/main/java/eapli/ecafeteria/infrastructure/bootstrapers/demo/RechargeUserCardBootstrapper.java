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
package eapli.ecafeteria.infrastructure.bootstrapers.demo;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CardMovementRepository;
import eapli.ecafeteria.infrastructure.bootstrapers.TestDataConstants;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.sales.application.RechargeUserCardController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.functional.Functions;
import eapli.framework.general.domain.model.Money;
import eapli.framework.validations.Invariants;

/**
 *
 * @author Paulo Gandra de Sousa
 */
public class RechargeUserCardBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(RechargeUserCardBootstrapper.class);

    private final CardMovementRepository movementsRepo = PersistenceContext.repositories().cardMovements();

    @Override
    public boolean execute() {
        return recharge(TestDataConstants.USER_TEST1, 75);
    }

    private boolean recharge(final String mecNumber, final double amount) {
        final RechargeUserCardController svc = new RechargeUserCardController();

        try {
            final CafeteriaUser u = findCafeteriaUser(mecNumber, svc).orElseThrow(() -> new IllegalStateException(
                    "Cannot recharge the card of user " + mecNumber + " as it does not exist"));

            // get current balance
            final Money currentBalance = movementsRepo.balanceOf(u.mecanographicNumber());

            svc.rechargeUserCard(u, amount);
            LOGGER.info("»»» {} @ {}", amount, mecNumber);

            // assert the recharge has been registered
            final Money newBalance = movementsRepo.balanceOf(u.mecanographicNumber());
            Invariants.ensure(newBalance.equals(currentBalance.add(Money.euros(amount))),
                    "Balance has not been properly updated when recharging");

        } catch (IntegrityViolationException | ConcurrencyException e) {
            LOGGER.error("While recharging {}€ for user {}", amount, mecNumber, e);
            return false;
        }
        return true;
    }

    @SuppressWarnings("squid:S1488")
    private Optional<CafeteriaUser> findCafeteriaUser(final String mecNumber,
            final RechargeUserCardController svc) {
        // since we might be using events, the actual user may not yet be
        // created, so lets give it a time and wait
        final Optional<CafeteriaUser> newUser = Functions.retry(
                () -> svc.findCafeteriaUserByMecNumber(mecNumber), 1000,
                3);
        return newUser;
    }
}
