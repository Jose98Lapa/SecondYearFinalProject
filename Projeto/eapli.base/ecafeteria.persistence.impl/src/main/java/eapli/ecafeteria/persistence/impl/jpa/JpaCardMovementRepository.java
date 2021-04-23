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
package eapli.ecafeteria.persistence.impl.jpa;

import javax.persistence.TypedQuery;

import eapli.ecafeteria.Application;
import eapli.ecafeteria.cafeteriausermanagement.domain.CardMovement;
import eapli.ecafeteria.cafeteriausermanagement.domain.MecanographicNumber;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CardMovementRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * @author mcn
 * @author Paulo Gandra de Sousa
 */
public class JpaCardMovementRepository extends JpaAutoTxRepository<CardMovement, Long, Long>
        implements CardMovementRepository {

    public JpaCardMovementRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaCardMovementRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<CardMovement> findByUsername(final Username user) {
        return match("e.user=(SELECT c FROM CafeteriaUser c WHERE c.systemUser.username=:name)",
                "name", user);
    }

    @Override
    public Iterable<CardMovement> findByMecanographicNumber(final MecanographicNumber number) {
        return match("e.user.mecanographicNumber=:number", "number", number);
    }

    /**
     * This method assumes the currency is EUR
     *
     * @remarks: The sum function of no rows results in null, when a value is
     *           expected
     *           (https://stackoverflow.com/questions/57002143/default-return-value-for
     *           -jpa-query). Corrected to fix this error with the coalesce clause.
     */
    @Override
    public Money balanceOf(final MecanographicNumber number) {
        final TypedQuery<Money> query = super.createQuery(
                "SELECT new eapli.framework.general.domain.model.Money"
                        + "(COALESCE(SUM(e.amount.amount),0), 'EUR') FROM CardMovement e "
                        + "WHERE e.user.mecanographicNumber=:number",
                Money.class);
        query.setParameter("number", number);
        return query.getSingleResult();
    }

    /**
     * @remarks: The sum function of no rows results in null, when a value is
     *           expected
     *           (https://stackoverflow.com/questions/57002143/default-return-value-for
     *           -jpa-query). Corrected to fix this error with the coalesce clause.
     * @param card
     * @return
     */
    @Override
    public Money balanceOf(final Username card) {
        final TypedQuery<Money> query = createQuery(
                "SELECT new eapli.framework.general.domain.model.Money"
                        + "(COALESCE(SUM" + "(e.amount.amount),0), 'EUR') FROM CardMovement e "
                        + "WHERE e.user.systemUser.username=:name",
                Money.class).setParameter("name", card);
        return query.getSingleResult();
    }
}
