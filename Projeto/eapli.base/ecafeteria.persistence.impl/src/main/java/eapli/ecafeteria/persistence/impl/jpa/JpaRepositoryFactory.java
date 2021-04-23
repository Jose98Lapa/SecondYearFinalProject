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

import eapli.ecafeteria.Application;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CardMovementRepository;
import eapli.ecafeteria.cafeteriausermanagement.repositories.SignupRequestRepository;
import eapli.ecafeteria.dishmanagement.repositories.AllergenRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.infrastructure.persistence.RepositoryFactory;
import eapli.ecafeteria.mealbooking.repositories.BookingRepository;
import eapli.ecafeteria.mealmanagement.repositories.MealRepository;
import eapli.ecafeteria.reporting.dishes.repositories.DishReportingRepository;
import eapli.ecafeteria.sales.repositories.CreditRechargeRepository;
import eapli.ecafeteria.traceability.repositories.MaterialRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * The repository factory for JPA repositories.
 *
 * <p>
 * This is the concrete factory in the Abstract Factory (GoF) pattern
 * </p>
 *
 * @author nuno 21/03/16
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public DishTypeRepository dishTypes() {
        return new JpaDishTypeRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public DishTypeRepository dishTypes(final TransactionalContext autoTx) {
        return new JpaDishTypeRepository(autoTx);
    }

    @Override
    public JpaCafeteriaUserRepository cafeteriaUsers(final TransactionalContext autoTx) {
        return new JpaCafeteriaUserRepository(autoTx);
    }

    @Override
    public JpaCafeteriaUserRepository cafeteriaUsers() {
        return new JpaCafeteriaUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public DishRepository dishes() {
        return new JpaDishRepository();
    }

    @Override
    public MaterialRepository materials() {
        return new JpaMaterialRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(
                Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public DishReportingRepository dishReporting() {
        return new JpaDishReportingRepository();
    }

    @Override
    public CardMovementRepository cardMovements() {
        return new JpaCardMovementRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CreditRechargeRepository creditRecharges() {
        return new JpaCreditRechargeRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CardMovementRepository cardMovements(final TransactionalContext autoTx) {
        return new JpaCardMovementRepository(autoTx);
    }

    @Override
    public CreditRechargeRepository creditRecharges(final TransactionalContext autoTx) {
        return new JpaCreditRechargeRepository(autoTx);
    }

    @Override
    public MealRepository meals() {
        return new JpaMealRepository();
    }

    @Override
    public BookingRepository bookings() {
        return new JpaBookingRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public AllergenRepository allergens() {
        return new JpaAllergenRepository();
    }

    @Override
    public BookingRepository bookings(final TransactionalContext ctx) {
        return new JpaBookingRepository(ctx);
    }
}
