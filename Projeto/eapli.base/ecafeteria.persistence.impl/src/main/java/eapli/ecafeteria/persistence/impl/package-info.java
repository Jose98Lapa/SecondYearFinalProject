/*
 * Copyright (c) 2013-2020 the original author or authors.
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
/**
 * Persistence implementations.
 *
 * <p>
 * The JPA repository implementations all follow a similar structure as the one depicted in the following diagram.
 * </p>
 * <p>
 * <img src="dishtyperepos.svg">
 * <p>
 *
 * <p>
 * In order to use any of the repositories implementations, it is necessary to have a factory object that will hide the
 * details of which implementation we are using. That is achived thru
 * {@link eapli.ecafeteria.infrastructure.persistence.PersistenceContext PersistenceContext} as depicted in the
 * following diagram.
 * </p>
 * <p>
 * <img src="persistence-context.svg">
 * <p>
 *
 * <!--
 *
 * @startuml persistence-context.svg
 *
 *           package core.infrastructure.persistence
 *           {
 *           class PersistenceContext
 *
 *           interface RepositoryFactory
 *           {
 *           DishTypeRepository dishTypes();
 *           }
 *           }
 *
 *           package persistence.impl.jpa
 *           {
 *           class JpaRepositoryFactory
 *           class JpaDishTypeRepository
 *           }
 *
 *           package persistence.impl.inmemory
 *           {
 *           class InMemoryRepositoryFactory
 *           class InMemoryDishTypeRepository
 *           }
 *
 *           package dishmanagement.repositories
 *           {
 *           interface DishTypeRepository
 *           }
 *
 *           PersistenceContext ..> RepositoryFactory
 *           InMemoryRepositoryFactory <.. PersistenceContext
 *           JpaRepositoryFactory <.. PersistenceContext
 *
 *           InMemoryRepositoryFactory ..|> RepositoryFactory
 *           JpaRepositoryFactory ..|> RepositoryFactory
 *
 *           DishTypeRepository <|.. JpaDishTypeRepository
 *           DishTypeRepository <|.. InMemoryDishTypeRepository
 *
 *           DishTypeRepository <.. RepositoryFactory
 *
 *           InMemoryDishTypeRepository <.. InMemoryRepositoryFactory:creates
 *
 *           JpaDishTypeRepository <.. JpaRepositoryFactory:creates
 *
 * @enduml
 *         -->
 *
 *
 *         <!--
 *
 * @startuml dishtyperepos.svg
 *
 *           class DishType
 *           {
 *           String acronym;
 *           String description;
 *           boolean active;
 *           }
 *
 *           interface DishTypeRepository
 *           {
 *           Iterable<DishType> activeDishTypes();
 *           }
 *           class JpaDishTypeRepository
 *           class InMemoryDishTypeRepository
 *
 *           DishTypeRepository <|.. JpaDishTypeRepository
 *           DishTypeRepository <|.. InMemoryDishTypeRepository
 *
 *
 *           class JpaBaseRepository
 *           class InMemoryDomainRepository
 *
 *           JpaDishTypeRepository --|> JpaBaseRepository
 *           InMemoryDishTypeRepository --|> InMemoryDomainRepository
 *           DishTypeRepository .left.> DishType
 *
 *           interface Repository<T, K>
 *           {
 *           <S extends T> S save(S entity);
 *           Iterable<T> findAll();
 *           Optional<T> findById(K id);
 *           void delete(T entity);
 *           void deleteById(K entityId);
 *           long count();
 *           }
 *
 *           JpaBaseRepository ..|> Repository :implements
 *           InMemoryDomainRepository ..|> Repository :implements
 *
 * @enduml
 *         -->
 */
package eapli.ecafeteria.persistence.impl;