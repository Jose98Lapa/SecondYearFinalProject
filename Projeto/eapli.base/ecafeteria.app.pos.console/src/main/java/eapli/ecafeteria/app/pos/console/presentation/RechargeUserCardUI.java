/*
 * Copyright (c) 2013-2020 the original author or authors.
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
package eapli.ecafeteria.app.pos.console.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.sales.application.RechargeUserCardController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 *
 * @author mcn
 */
@SuppressWarnings("squid:S106")
public class RechargeUserCardUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(RechargeUserCardUI.class);

    private final RechargeUserCardController theController = new RechargeUserCardController();

    private boolean recharge(final CafeteriaUser u) {
        final double value = Console.readDouble("Ammount to charge:");
        try {
            theController.rechargeUserCard(u, value);
        } catch (@SuppressWarnings("unused") final ConcurrencyException e) {
            System.out.println(
                    "WARNING: The user data has been changed or deleted by other user. Please try again.");
        } catch (final IntegrityViolationException e) {
            LOGGER.error("This should never happen", e);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }

        return false;
    }

    @Override
    protected boolean doShow() {

        final String mecNumber = Console.readLine("Mecanographic Number (0 to cancel):");
        if (!mecNumber.equals("0")) {
            return theController.findCafeteriaUserByMecNumber(mecNumber).map(this::recharge)
                    .orElseGet(() -> {
                        System.out.println("Invalid or inexistent mecanographic number.");
                        return true;
                    });
        }
        return true;
    }

    @Override
    public String headline() {
        return "RECHARGE USER CARD";
    }
}
