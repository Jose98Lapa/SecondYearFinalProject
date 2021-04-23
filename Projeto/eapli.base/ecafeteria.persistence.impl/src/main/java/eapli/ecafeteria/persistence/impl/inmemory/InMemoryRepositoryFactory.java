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
package eapli.ecafeteria.persistence.impl.inmemory;

import eapli.ecafeteria.cafeteriausermanagement.repositories.CafeteriaUserRepository;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CardMovementRepository;
import eapli.ecafeteria.cafeteriausermanagement.repositories.SignupRequestRepository;
import eapli.ecafeteria.dishmanagement.repositories.AllergenRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.infrastructure.bootstrapers.ECafeteriaBootstrapper;
import eapli.ecafeteria.infrastructure.persistence.RepositoryFactory;
import eapli.ecafeteria.mealbooking.repositories.BookingRepository;
import eapli.ecafeteria.mealmanagement.repositories.MealRepository;
import eapli.ecafeteria.reporting.dishes.repositories.DishReportingRepository;
import eapli.ecafeteria.sales.repositories.CreditRechargeRepository;
import eapli.ecafeteria.traceability.repositories.MaterialRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryTransactionalContext;

/**
 *
 * @author nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    /**
     * Initialize a power user so that we can login.
     */
    @Override
    public UserRepository users(final TransactionalContext tx) {
        final InMemoryUserRepository repo = new InMemoryUserRepository();
        ECafeteriaBootstrapper.registerPowerUser(repo);
        return repo;
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public DishTypeRepository dishTypes() {
        return dishTypes(null);
    }

    @Override
    public DishTypeRepository dishTypes(final TransactionalContext tx) {
        return new InMemoryDishTypeRepository();
    }

    @Override
    public CafeteriaUserRepository cafeteriaUsers(final TransactionalContext tx) {

        return new InMemoryCafeteriaUserRepository();
    }

    @Override
    public CafeteriaUserRepository cafeteriaUsers() {
        return cafeteriaUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public DishRepository dishes() {
        return new InMemoryDishRepository();
    }

    @Override
    public MaterialRepository materials() {
        return new InMemoryMaterialRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return new InMemoryTransactionalContext();
    }

    @Override
    public DishReportingRepository dishReporting() {
        return new InMemoryDishReportingRepository();
    }

    @Override
    public CardMovementRepository cardMovements() {
        return new InMemoryCardMovementRepository();
    }

    @Override
    public CreditRechargeRepository creditRecharges() {
        return new InMemoryCreditRechargeRepository();
    }

    @Override
    public CardMovementRepository cardMovements(final TransactionalContext autoTx) {
        return cardMovements(null);
    }

    @Override
    public CreditRechargeRepository creditRecharges(final TransactionalContext autoTx) {
        return creditRecharges(null);
    }

    @Override
    public MealRepository meals() {
        return new InMemoryMealRepository();
    }

    @Override
    public BookingRepository bookings() {
        return new InMemoryBookingRepository();
    }

    @Override
    public AllergenRepository allergens() {
        return new InMemoryAllergenRepository();
    }

    @Override
    public BookingRepository bookings(final TransactionalContext ctx) {
        return new InMemoryBookingRepository();
    }
}
