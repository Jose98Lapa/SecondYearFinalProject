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
package eapli.ecafeteria.reporting.dishes.application;

import eapli.ecafeteria.Application;
import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.reporting.dishes.dto.DishesPerCaloricCategory;
import eapli.ecafeteria.reporting.dishes.dto.DishesPerDishType;
import eapli.ecafeteria.reporting.dishes.repositories.DishReportingRepository;
import eapli.framework.application.UseCaseController;

/**
 * Reporting is a separate concern from business logic, as such we are placing
 * reporting features in a separate package structure.
 *
 * <p>
 * <img src="dish-reporting.svg">
 * </p>
 *
 * @author Paulo Gandra de Sousa
 *
 *         <!--
 *
 * @startuml dish-reporting.svg
 *
 *           Title Class Diagram for DishReporting
 *
 *           interface DishReportingRepository
 *           {
 *
 *           Iterable<DishesPerDishType> dishesPerDishType();
 *           Iterable<Dish> reportHighCaloriesDishes(Integer highCalories);
 *           Iterable<DishesPerCaloricCategory> reportDishesPerCaloricCategory();
 *           Iterable<Object[]> reportDishesPerCaloricCategoryAsTuples();
 *           }
 *
 *           class JpaDishReportingRepository extends CafeteriaJpaReportingRepositoryBase
 *           {
 *           }
 *
 *           interface CafeteriaJpaReportingRepositoryBase extends JpaTransactionalContext
 *           {
 *           }
 *
 *
 *           JpaDishReportingRepository .up.|> DishReportingRepository : implements
 *
 *           'InMemoryDishReportingRepository .up.> DishReportingRepository
 *
 *           DishReportingRepository -up-> DishesPerDishType
 *           DishReportingRepository -up-> Dish
 *           DishReportingRepository -up-> DishesPerCaloricCategory
 *           DishReportingRepository -up-> Object
 *
 *
 *           class DishesPerDishType
 *           {
 *           String dishType;
 *           long quantityOfDishes;
 *           }
 *
 * @enduml
 *         -->
 */
@UseCaseController
public class DishReportingController {

    private final DishReportingRepository repo = PersistenceContext.repositories().dishReporting();

    /**
     * Reports the number of dishes per dish type. In this case we are using a custom reporting DTO.
     *
     * @return
     */
    public Iterable<DishesPerDishType> reportDishesPerDishType() {
        return repo.dishesPerDishType();
    }

    /**
     * Reports the dishes that have a high calorie count. "High calorie" is defined in the
     * application properties.
     *
     * @return
     */
    public Iterable<Dish> reportHighCaloriesDishes() {
        return repo.reportHighCaloriesDishes(Application.settings().getHighCaloriesDishLimit());
    }

    /**
     * Reports the number of dishes per caloric group (low, medium, high). In this case we are using
     * a custom DTO.
     *
     * @return
     */
    public Iterable<DishesPerCaloricCategory> reportDishesPerCaloricCategory() {
        return repo.reportDishesPerCaloricCategory();
    }

    /**
     * Reports the number of dishes per caloric group (low, medium, high). In this case we are
     * returning the data as standard tuples (arrays of objects).
     *
     * @return
     */
    public Iterable<Object[]> reportDishesPerCaloricCategoryAsTuples() {
        return repo.reportDishesPerCaloricCategoryAsTuples();

    }
}
