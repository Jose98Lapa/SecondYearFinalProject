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
package eapli.ecafeteria.app.backoffice.console.presentation.dishes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecafeteria.dishmanagement.application.ChangeDishController;
import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Money;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author PRP 29.mar.2017
 */
@SuppressWarnings("squid:S106")
class ChangeDishPriceUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(ChangeDishPriceUI.class);

    private final ChangeDishController theController = new ChangeDishController();

    @Override
    protected boolean doShow() {

        final Iterable<Dish> allDishes = this.theController.allDishes();
        if (!allDishes.iterator().hasNext()) {
            System.out.println("There are no registered Dishes");
        } else {
            final SelectWidget<Dish> selector = new SelectWidget<>("Dishes:", allDishes,
                    new DishPrinter());
            selector.show();
            final Dish selectedDish = selector.selectedElement();
            System.out.println("Current  price: " + selectedDish.currentPrice().toString());
            try {
                final double newPrice = Console.readDouble(" New price");
                this.theController.changeDishPrice(selectedDish, Money.euros(newPrice));
            } catch (@SuppressWarnings("unused") final ConcurrencyException ex) {
                System.out.println(
                        "WARNING: It is not possible to change the dish state because it was changed by another user");
            } catch (final IntegrityViolationException ex) {
                LOGGER.error("Error performing the operation", ex);
                System.out.println(
                        "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Change Dish price";
    }
}
