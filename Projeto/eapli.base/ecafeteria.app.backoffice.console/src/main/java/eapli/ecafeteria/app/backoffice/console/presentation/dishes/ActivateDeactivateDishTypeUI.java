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

import eapli.ecafeteria.dishmanagement.application.ActivateDeactivateDishTypeController;
import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 * Created by MCN on 29/03/2016.
 */
@SuppressWarnings("squid:S106")
public class ActivateDeactivateDishTypeUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(ActivateDeactivateDishTypeUI.class);

    private final ActivateDeactivateDishTypeController theController = new ActivateDeactivateDishTypeController();

    @Override
    protected boolean doShow() {

        final Iterable<DishType> allDishTypes = this.theController.allDishTypes();
        if (!allDishTypes.iterator().hasNext()) {
            System.out.println("There are no registered Dish Types");
        } else {
            final SelectWidget<DishType> selector = new SelectWidget<>("Dish types:", allDishTypes,
                    new DishTypePrinter());
            selector.show();
            final DishType updtDishType = selector.selectedElement();
            try {
                if (updtDishType != null) {
                    this.theController.changeDishTypeState(updtDishType);
                }
            } catch (@SuppressWarnings("unused") final ConcurrencyException ex) {
                System.out.println(
                        "WARNING: It is not possible to change the dish type state because it was changed by another user");
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
        return "Activate / Deactivate Dish Types";
    }
}
