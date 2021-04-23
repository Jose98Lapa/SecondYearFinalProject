/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.ecafeteria.mycafeteriauser.application;

import java.util.Optional;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CafeteriaUserRepository;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CardMovementRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 *
 * @author Paulo Gandra de Sousa
 */
@ApplicationService
public class MyCafeteriaUserService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CafeteriaUserRepository cafeteriaUsersRepo = PersistenceContext.repositories().cafeteriaUsers();
    private final CardMovementRepository movementsRepo = PersistenceContext.repositories()
            .cardMovements();

    public CafeteriaUser me() {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.CAFETERIA_USER);

        // TODO cache the cafeteria user object
        final Optional<CafeteriaUser> me = cafeteriaUsersRepo.findByUsername(myUser().identity());

        return me.orElseThrow(IllegalStateException::new);
    }

    private SystemUser myUser() {
        return authz.session().map(UserSession::authenticatedUser)
                .orElseThrow(IllegalStateException::new);
    }

    /**
     * Returns the card balance of the authenticated cafeteria user.
     *
     * @return
     */
    public Money myBalance() {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.CAFETERIA_USER);

        return movementsRepo.balanceOf(myUser().identity());
    }
}
