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
package eapli.ecafeteria.app.user.console.presentation.mybookings;

import java.util.function.Supplier;

import eapli.ecafeteria.mycafeteriauser.application.MyCafeteriaUserService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.ListUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author mcn
 */
@SuppressWarnings({ "squid:S106" })
public class ListMovementsUI<T> extends ListUI<T> {

    private final MyCafeteriaUserService theController = new MyCafeteriaUserService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public ListMovementsUI(final Supplier<Iterable<T>> source, final Visitor<T> printer,
            final String elementName, final String headline, final String emptyMessage) {
        super(source, printer, elementName,
                String.format("#  %-15s%-15s%-10s", "ON", "TYPE", "AMOUNT"), headline,
                emptyMessage);
    }

    /**
     *
     * @return true if the user wants to leave this UI
     */
    @Override
    protected boolean doShow() {
        final Iterable<T> dishTypes = elements();
        if (!dishTypes.iterator().hasNext()) {
            System.out.println("There is no registered " + elementName());
        } else {
            new ListWidget<>("Listing " + elementName() + "s", dishTypes, elementPrinter()).show();
        }
        return true;
    }

    public String showBalance() {
        return "CURRENT BALANCE OF YOUR USERCARD:  " + theController.myBalance().toString();

    }

    @Override
    public String headline() {
        return authz.session().map(
                s -> "eCAFETERIA [@" + s.authenticatedUser().identity() + "]   " + showBalance())
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    protected void drawFormTitle(final String title) {
        final String titleBorder = BORDER.substring(0, 2) + " " + title;
        System.out.println(titleBorder);
        drawFormBorder();
    }
}
