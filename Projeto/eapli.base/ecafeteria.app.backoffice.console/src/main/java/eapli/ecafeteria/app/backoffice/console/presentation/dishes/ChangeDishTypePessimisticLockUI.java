/*
 * Copyright (c) 2013-2021 the original author or authors.
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

import eapli.ecafeteria.dishmanagement.application.ChangeDishTypePessimisticLockController;
import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 * An example user interface following a pessimistic lock strategy.
 * <p>
 * For interactive use cases, one must understand that this approach only works in "connected"
 * environments like GUI and CLI. On a "disconnected" environment like a web application or web
 * service pessimistic locking based on the user interaction must be handled with a locking table.
 *
 * @see ChangeDishTypeUI
 * @author Paulo Gandra Sousa 2021.03.30
 */
@SuppressWarnings("squid:S106")
public class ChangeDishTypePessimisticLockUI extends AbstractUI {
    private final ChangeDishTypePessimisticLockController controller = new ChangeDishTypePessimisticLockController();

    @Override
    protected boolean doShow() {
        final Iterable<DishType> dishTypes = this.controller.dishTypes();
        final SelectWidget<DishType> selector = new SelectWidget<>("Dish types:", dishTypes,
                new DishTypePrinter());
        selector.show();
        DishType theDishType = selector.selectedElement();
        if (theDishType != null) {
            try {
                // since we follow a pessimistic lock strategy we need to ask the controller to lock
                // the desired object
                theDishType = controller.grantExclusiveAccessTo(theDishType);
                System.out.println("INFO: Locking " + theDishType);
            } catch (final ConcurrencyException e) {
                System.out.println(
                        "WARNING: Could not acquire exclusive access to that entity; other user is provably modifying it. Try again in a moment.");
                return false;
            }

            final String newDescription = Console
                    .readLine("Enter new description for " + theDishType.identity() + ": ");
            theDishType = controller.changeDishType(newDescription);

            System.out.print("TRACE: modified object ");
            System.out.println(theDishType);
        }
        return false;
    }

    @Override
    public String headline() {
        return "Change Dish Type description";
    }
}
