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
package eapli.ecafeteria.sales.application;

import java.util.Optional;

import eapli.ecafeteria.cafeteriausermanagement.application.CafeteriaUserService;
import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.cafeteriausermanagement.domain.CardMovement;
import eapli.ecafeteria.cafeteriausermanagement.domain.MovementType;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CardMovementRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.sales.domain.CreditRecharge;
import eapli.ecafeteria.sales.repositories.CreditRechargeRepository;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author mcn
 */
@UseCaseController
public class RechargeUserCardController {

    private final CafeteriaUserService svc = new CafeteriaUserService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final TransactionalContext ctx = PersistenceContext.repositories().newTransactionalContext();
    private final CreditRechargeRepository rechargeRepo = PersistenceContext.repositories().creditRecharges(ctx);
    private final CardMovementRepository movementRepo = PersistenceContext.repositories().cardMovements(ctx);

    public Optional<CafeteriaUser> findCafeteriaUserByMecNumber(final String mecNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER, CafeteriaRoles.CASHIER);
        return svc.findCafeteriaUserByMecNumber(mecNumber);
    }

    /**
     * Note: Follows a Transactional approach.
     *
     * @param user
     * @param ammount
     * @return
     */
    public CardMovement rechargeUserCard(final CafeteriaUser user, final double ammount) {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER, CafeteriaRoles.CASHIER);

        ctx.beginTransaction();

        // credit recharge (POS)
        rechargeRepo.save(new CreditRecharge(user, Money.euros(ammount)));

        // TODO avoid duplication with {@link CreditUserCardController}
        // credit recharge (cafeteria user's account)
        CardMovement creditMovement = new CardMovement(MovementType.RECHARGE, Money.euros(ammount),
                user);
        creditMovement = movementRepo.save(creditMovement);

        ctx.commit();

        return creditMovement;
    }
}
