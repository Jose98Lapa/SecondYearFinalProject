/*
 * Copyright (c) 2013-2019 the original author or authors.
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
package eapli.base.app.user.console.presentation;

import eapli.base.app.user.console.presentation.checkUserTickets.CheckUserTickersUI;
import eapli.base.app.user.console.presentation.completeTaskUI.CompleteTaskUI;
import eapli.base.app.user.console.presentation.requestService.RequestServiceUI;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.app.user.console.presentation.checkServicesUI.CheckServicesUI;
import eapli.base.app.user.console.presentation.dashboard.ShowDashboardUI;
import eapli.base.app.user.console.presentation.redeemTaskController.RedeemTaskUI;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * @author Paulo Gandra Sousa
 */
class MainMenu extends ClientUserBaseUI {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN = "Return ";

    private static boolean firstTime = true;

    private static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    private static final int EXIT_OPTION = 0;


    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int CONSULTAR_SERVICO_OPTION = 2;
    private static final int REIVINDICAR_TAREFA = 3;
    private static final int COMPLETAR_TAREFA = 4;
    private static final int CHECKTICKETS = 5;


    private final AuthorizationService authz =
            AuthzRegistry.authorizationService();

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
        if (firstTime) {
            new ShowDashboardUI().show();
            firstTime = false;
        }
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);
        mainMenu.addSubMenu(CONSULTAR_SERVICO_OPTION, builderConsultarServicoMenu());
        mainMenu.addSubMenu(REIVINDICAR_TAREFA,builderRedeemTaskMenu());
        mainMenu.addSubMenu(COMPLETAR_TAREFA,builderCompleteTaskMenu());
        mainMenu.addSubMenu(CHECKTICKETS,builderCheckUserTickets());

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu builderCompleteTaskMenu(){
        final Menu completeTaskMenu = new Menu("Completar Tarefa");
        completeTaskMenu.addItem(1,"Completar Tarefa",()->new CompleteTaskUI().show());
        completeTaskMenu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return completeTaskMenu;
    }

    private Menu builderConsultarServicoMenu() {
        final Menu consultarServicoMenu = new Menu("Consultar Serviços");
        consultarServicoMenu.addItem(1, "Consultar Serviços", () -> new CheckServicesUI().show());
        consultarServicoMenu.addItem(2, "Pedir serviço", () -> new RequestServiceUI().show());
        consultarServicoMenu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return consultarServicoMenu;
    }

    private Menu builderRedeemTaskMenu() {
        final Menu redeemTaskMenu = new Menu("Reivindicar Tarefa");
        redeemTaskMenu.addItem(2, "Reivindicar Tarefa", () -> new RedeemTaskUI().show());
        redeemTaskMenu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return redeemTaskMenu;
    }

    private Menu builderCheckUserTickets() {
        final Menu visualizar_tickets = new Menu("Visualizar Tickets");
        visualizar_tickets.addItem(1, "Visualizar Tickets", () -> new CheckUserTickersUI().show());
        visualizar_tickets.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return visualizar_tickets;
    }

}
