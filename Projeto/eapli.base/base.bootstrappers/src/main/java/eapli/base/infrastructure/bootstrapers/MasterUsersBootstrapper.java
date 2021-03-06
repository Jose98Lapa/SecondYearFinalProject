/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import java.util.HashSet;
import java.util.Set;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerAdmin("admin", TestDataConstants.PASSWORD1, "Jane", "Doe Admin",
                "admin@email.local");
        registerRRH("rrh", "123456789Aa?", "Rui", "Silva",
                "rrh@email.local");
        registerGSH("gsh", "123456789Aa?", "Tomas", "Flores",
                "gshe@email.local");
        registerGSH("Tomas","Tiago123","Tomas","Machado","raf@isep.ipp.pt");
        return true;
    }

    /**
     *
     */
    private void registerAdmin(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        registerUser(username, password, firstName, lastName, email, roles);
    }
    private void registerRRH(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.RRH);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerGSH(final String username, final String password, final String firstName,
                             final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.GSH);

        registerUser(username, password, firstName, lastName, email, roles);
    }
}
