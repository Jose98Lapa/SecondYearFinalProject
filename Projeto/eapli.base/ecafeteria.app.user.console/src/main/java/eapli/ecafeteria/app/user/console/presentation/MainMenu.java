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
package eapli.ecafeteria.app.user.console.presentation;

import java.util.Optional;

import eapli.cafeteria.app.common.console.presentation.authz.MyUserMenu;
import eapli.ecafeteria.app.user.console.presentation.mybookings.BookingPrinter;
import eapli.ecafeteria.app.user.console.presentation.mybookings.ListMovementsUI;
import eapli.ecafeteria.app.user.console.presentation.mybookings.MovementPrinter;
import eapli.ecafeteria.app.user.console.presentation.mybookings.RegisterBookingUI;
import eapli.ecafeteria.mealbooking.application.MyBookingsController;
import eapli.ecafeteria.sales.application.ListMovementsController;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ListUI;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * @author Paulo Gandra Sousa
 */
class MainMenu extends CafeteriaUserBaseUI {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN = "Return ";

    private static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int BOOKINGS_OPTION = 2;
    private static final int ACCOUNT_OPTION = 3;
    private static final int SETTINGS_OPTION = 4;

    // BOOKINGS MENU
    private static final int BOOK_A_MEAL_OPTION = 2;
    private static final int LIST_MY_BOOKINGS_OPTION = 3;

    // ACCOUNT MENU
    private static final int LIST_MOVEMENTS_OPTION = 1;

    // SETTINGS
    private static final int SET_USER_ALERT_LIMIT_OPTION = 1;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final var renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        final Menu bookingsMenu = buildBookingsMenu();
        mainMenu.addSubMenu(BOOKINGS_OPTION, bookingsMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        final Menu accountMenu = buildAccountMenu();
        mainMenu.addSubMenu(ACCOUNT_OPTION, accountMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        final Menu settingsMenu = buildAdminSettingsMenu();
        mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAccountMenu() {
        final Menu accountMenu = new Menu("Account");
        accountMenu.addItem(LIST_MOVEMENTS_OPTION, "List movements", () -> {
            final Optional<UserSession> s = authz.session();
            // example of using an extended class of generic list ui from the
            // framework
            new ListMovementsUI<>(
                    () -> new ListMovementsController().allMovementsByUsername(
                            s.orElseThrow(IllegalStateException::new).authenticatedUser()
                                    .identity()),
                    new MovementPrinter(), "Movement", "List My Movements",
                    "No data").show();
            return true;
        });
        accountMenu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return accountMenu;
    }

    private Menu buildBookingsMenu() {
        final Menu menu = new Menu("Bookings");
        menu.addItem(BOOK_A_MEAL_OPTION, "Book a meal", () -> new RegisterBookingUI().show());

        menu.addItem(LIST_MY_BOOKINGS_OPTION, "My Bookings", () -> {
            new ListUI<>(new MyBookingsController().myBookings(), new BookingPrinter(), "Booking",
                    String.format("   %-40s %-15s %s", "TOKEN", "DAY", "STATUS"), "List My Bookings",
                    "No data").show();
            return true;
        });
        menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return menu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_USER_ALERT_LIMIT_OPTION, "Set users' alert limit",
                new ShowMessageAction(NOT_IMPLEMENTED_YET));
        menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);

        return menu;
    }
}
