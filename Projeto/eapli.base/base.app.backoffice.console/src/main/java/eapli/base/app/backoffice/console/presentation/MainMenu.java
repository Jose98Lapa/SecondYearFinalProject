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
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.assignCriticalityLevel.AssignCriticalityLevelUI;
import eapli.base.app.backoffice.console.presentation.associateCollaborator.AssociateCollaboratorUI;
import eapli.base.app.backoffice.console.presentation.checkActivityFlux.CheckActivityFluxUI;
import eapli.base.app.backoffice.console.presentation.createCatalogue.CreateCatalogueUI;
import eapli.base.app.backoffice.console.presentation.createColour.CreateColourUI;
import eapli.base.app.backoffice.console.presentation.createTeam.CreateTeamUI;
import eapli.base.app.backoffice.console.presentation.createTeamType.CreateTeamTypeUI;
import eapli.base.app.backoffice.console.presentation.removeCollaborator.RemoveCollaboratorUI;
import eapli.base.app.backoffice.console.presentation.specifyCollaborator.SpecifyCollaboratorUI;
import eapli.base.app.backoffice.console.presentation.specifyCriticality.SpecifyCriticalityUI;
import eapli.base.app.backoffice.console.presentation.specifyService.CompleteServiceUI;
import eapli.base.app.backoffice.console.presentation.specifyService.SpecifyServiceUI;
import eapli.base.app.backoffice.console.presentation.specifyService.ToggleService;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    private static final String RETURN = "Return ";

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // SETTINGS
    private static final int CRIAR_COR = 2;

    //RRH
    private static final int ESPECIFICAR_COLLABORADOR_OPTION = 2;
    private static final int CRIAR_EQUIPA_OPTION = 3;
    private static final int CRIAR_TIPO_EQUIPA_OPTION = 4;


    //GSH
    private static final int CRIAR_CATALOGO_OPTION = 2;
    private static final int SERVICE_OPTION = 3;
    private static final int ESPECIFICAR_CRITICIDADE_OPTION = 4;
    private static final int VERIFICAR_ESTADO_OPTION = 5;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 4;

    private static final String SEPARATOR_LABEL = "--------------";

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
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
            mainMenu.addSubMenu(CRIAR_COR,buildCorMenu());
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.RRH)) {
            final Menu especificarColaboradorMenu = buildEspecificarColaboradorMenu();
            mainMenu.addSubMenu(ESPECIFICAR_COLLABORADOR_OPTION,especificarColaboradorMenu);
            final Menu criarequipaMenu = buildEquipaMenu();
            mainMenu.addSubMenu(CRIAR_EQUIPA_OPTION,criarequipaMenu);
            final Menu criarTipoEquipaMenu = buildTipoEquipaMenu();
            mainMenu.addSubMenu(CRIAR_TIPO_EQUIPA_OPTION,criarTipoEquipaMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.GSH)) {
            final Menu catalogoMenu = buildCatalogoMenu();
            mainMenu.addSubMenu(CRIAR_CATALOGO_OPTION, catalogoMenu);
            final Menu servicoMenu = buildServicoMenu();
            mainMenu.addSubMenu(SERVICE_OPTION, servicoMenu);
            final Menu especificarCriticidadeMenu = buildEspecificarCriticidadeMenu();
            mainMenu.addSubMenu(ESPECIFICAR_CRITICIDADE_OPTION,especificarCriticidadeMenu);
            final Menu checkActivityFluxMenu = buildCheckActivityFluxMenu();
            mainMenu.addSubMenu(VERIFICAR_ESTADO_OPTION,checkActivityFluxMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        // menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit", new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildTipoEquipaMenu(){
        final Menu tipoEquipaMenu = new Menu("Tipo Equipa");
        tipoEquipaMenu.addItem(1,"Criar Tipo Equipa",()->new CreateTeamTypeUI().show());
        tipoEquipaMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return tipoEquipaMenu;
    }

    private Menu buildEspecificarColaboradorMenu(){
        final Menu colaboradorMenu = new Menu("Colaborador");
        colaboradorMenu.addItem(1,"Especificar Colaborador",() -> new SpecifyCollaboratorUI().show());
        colaboradorMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return colaboradorMenu;
    }

    private Menu buildEditarServico(){
        final Menu corMenu = new Menu("Alterar Servico");
        corMenu.addItem(1,"Alterar Servico",()->new CompleteServiceUI().show());
        corMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return corMenu;
    }
    private Menu buildAtivarDesativarServico(){
        final Menu corMenu = new Menu("Ativar/Desativar Servico");
        corMenu.addItem(1,"Ativar/Desativar Servico",()->new ToggleService().show());
        corMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return corMenu;
    }

    private Menu buildEquipaMenu() {
        final Menu equipaMenu = new Menu("Equipa");
        equipaMenu.addItem(1, "Criar Equipa", () -> new CreateTeamUI().show());
        equipaMenu.addItem(2,"Associar Colaborador",()->new AssociateCollaboratorUI().show());
        equipaMenu.addItem(3,"Remover Colaborador",()->new RemoveCollaboratorUI().show());
        equipaMenu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return equipaMenu;
    }
    private Menu buildServicoMenu() {
        final Menu servicoMenu = new Menu("Servico");
        servicoMenu.addItem(1, "Especificar Servico", ()-> new SpecifyServiceUI().show());
        servicoMenu.addItem(2,"Alterar Servico",()->new CompleteServiceUI().show());
        servicoMenu.addItem(3,"Ativar/Desativar Servico",()->new ToggleService().show());
        servicoMenu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return servicoMenu;
    }

    private Menu buildCatalogoMenu() {
        final Menu equipaMenu = new Menu("Catalogo");
        equipaMenu.addItem(1, "Criar Catalogo", () -> new CreateCatalogueUI().show());
        equipaMenu.addItem(2, "Associar Nivel Criticidade", () -> new AssignCriticalityLevelUI().show());
        equipaMenu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return equipaMenu;
    }

    private Menu buildEspecificarCriticidadeMenu(){
        final Menu criticidadeMenu = new Menu("Criticidade");
        criticidadeMenu.addItem(1,"Especificar Criticidade",() -> new SpecifyCriticalityUI().show());
        criticidadeMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return criticidadeMenu;
    }


    private Menu buildCorMenu(){
        final Menu corMenu = new Menu("Cor");
        corMenu.addItem(1,"Adicionar Cor",()->new CreateColourUI().show());
        corMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return corMenu;
    }

    private Menu buildCheckActivityFluxMenu(){
        final Menu checkActivityFluxMenu = new Menu("Motor de execução de atividade");
        checkActivityFluxMenu.addItem(1,"Verificar Estado de motor de execução",()->new CheckActivityFluxUI().show());
        checkActivityFluxMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return checkActivityFluxMenu;
    }






}
