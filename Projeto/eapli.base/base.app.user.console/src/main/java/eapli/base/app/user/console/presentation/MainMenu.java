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

import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.app.user.console.presentation.CriarCor.CriarCorUI;
import eapli.base.app.user.console.presentation.CriarEquipa.CriarEquipaUI;
import eapli.base.app.user.console.presentation.CriarTipoEquipa.CriarTipoEquipaUI;
import eapli.base.app.user.console.presentation.EspecificarColaborador.EspecificarColaboradorUI;
import eapli.base.app.user.console.presentation.CriarCatalogo.CriarCatalogoUI;
import eapli.base.app.user.console.presentation.EspecificarServico.AtivarDesativarServico;
import eapli.base.app.user.console.presentation.EspecificarServico.CompletarServicoUI;
import eapli.base.app.user.console.presentation.EspecificarServico.EspecificarServicoUI;
import eapli.base.usermanagement.domain.BaseRoles;
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

    private static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int REGISTER_SERVICE_OPTION = 2;
    private static final int CRIAR_EQUIPA_OPTION = 3;
    private static final int CRIAR_CATALOGO_OPTION = 4;
    private static final int ESPECIFICAR_COLLABORADOR_OPTION = 5;
    private static final int CRIAR_TIPO_EQUIPA_OPTION = 6;
    private static final int CRIAR_COR = 7;
    private static final int EDITAR_SERVICO = 8;
    private static final int TOGGLE_SERVICO = 9;


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
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

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
            final Menu criarServicoMenu = buildServicoMenu();
            mainMenu.addSubMenu(REGISTER_SERVICE_OPTION, criarServicoMenu);
            final Menu editarServicoMenu = buildEditarServico();
            mainMenu.addSubMenu(EDITAR_SERVICO,editarServicoMenu);
            final Menu toggleServicoMenu = buildAtivarDesativarServico();
            mainMenu.addSubMenu(TOGGLE_SERVICO,toggleServicoMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER,BaseRoles.ADMIN)) {
            mainMenu.addSubMenu(CRIAR_COR,buildCorMenu());
        }

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildServicoMenu() {
        final Menu servicoMenu = new Menu("Especificar Servico");
        servicoMenu.addItem(1, "Especificar Servico", () -> new EspecificarServicoUI().show());
        servicoMenu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return servicoMenu;
    }

    private Menu buildEquipaMenu() {
        final Menu equipaMenu = new Menu("Equipa");
        equipaMenu.addItem(1, "Criar Equipa", () -> new CriarEquipaUI().show());
        equipaMenu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return equipaMenu;
    }

    private Menu buildCatalogoMenu() {
        final Menu equipaMenu = new Menu("Catalogo");
        equipaMenu.addItem(1, "Criar Catalogo", () -> new CriarCatalogoUI().show());
        equipaMenu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return equipaMenu;
    }

    private Menu buildEspecificarColaboradorMenu(){
        final Menu colaboradorMenu = new Menu("Colaborador");
        colaboradorMenu.addItem(1,"Especificar Colaborador",() -> new EspecificarColaboradorUI().show());
        colaboradorMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return colaboradorMenu;
    }

    private Menu buildTipoEquipaMenu(){
        final Menu tipoEquipaMenu = new Menu("Tipo Equipa");
        tipoEquipaMenu.addItem(1,"Criar Tipo Equipa",()->new CriarTipoEquipaUI().show());
        tipoEquipaMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return tipoEquipaMenu;
    }

    private Menu buildCorMenu(){
        final Menu corMenu = new Menu("Cor");
        corMenu.addItem(1,"Adicionar Cor",()->new CriarCorUI().show());
        corMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return corMenu;
    }

    private Menu buildEditarServico(){
        final Menu corMenu = new Menu("Alterar Servico");
        corMenu.addItem(1,"Alterar Servico",()->new CompletarServicoUI().show());
        corMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return corMenu;
    }
    private Menu buildAtivarDesativarServico(){
        final Menu corMenu = new Menu("Ativar/Desativar Servico");
        corMenu.addItem(1,"Ativar/Desativar Servico",()->new AtivarDesativarServico().show());
        corMenu.addItem(EXIT_OPTION,RETURN,Actions.SUCCESS);
        return corMenu;
    }
}
