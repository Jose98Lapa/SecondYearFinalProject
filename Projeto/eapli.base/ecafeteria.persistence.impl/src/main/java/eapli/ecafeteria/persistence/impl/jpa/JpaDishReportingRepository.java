/*
 * Copyright (c) 2013-2020 the original author or authors.
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
package eapli.ecafeteria.persistence.impl.jpa;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.reporting.dishes.dto.DishesPerCaloricCategory;
import eapli.ecafeteria.reporting.dishes.dto.DishesPerDishType;
import eapli.ecafeteria.reporting.dishes.repositories.DishReportingRepository;

/**
 *
 * @author Paulo Gandra de Sousa
 */
public class JpaDishReportingRepository extends CafeteriaJpaReportingRepositoryBase
        implements DishReportingRepository {

    JpaDishReportingRepository() {
        super();
    }

    @Override
    public Iterable<DishesPerDishType> dishesPerDishType() {

        final TypedQuery<DishesPerDishType> query = entityManager().createQuery(
                "SELECT new eapli.ecafeteria.reporting.dishes.dto.DishesPerDishType(t.acronym, COUNT(d)) FROM Dish d, DishType t WHERE d.dishType = t GROUP BY d.dishType",
                DishesPerDishType.class);

        return query.getResultList();
    }

    @Override
    public Iterable<Dish> reportHighCaloriesDishes(final Integer highCalories) {
        final TypedQuery<Dish> query = entityManager()
                .createQuery("SELECT d FROM Dish d WHERE d.nutricionalInfo.calories > :hc",
                        Dish.class);
        query.setParameter("hc", highCalories);
        return query.getResultList();
    }

    private static final String DISHES_PER_CALORIC_CATEGORY_QUERY = "SELECT caloricCategory, COUNT(*) as n "
            + "FROM (SELECT *, CASE WHEN calories <= 150 THEN 'low' WHEN calories > 150 AND calories < 350 THEN 'medium' ELSE 'high' END AS caloricCategory FROM DISH) "
            + "GROUP BY caloricCategory";

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<DishesPerCaloricCategory> reportDishesPerCaloricCategory() {
        final Query query = entityManager().createNativeQuery(DISHES_PER_CALORIC_CATEGORY_QUERY,
                "DishesPerCaloricCategoryMapping");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<Object[]> reportDishesPerCaloricCategoryAsTuples() {
        final Query query = entityManager().createNativeQuery(DISHES_PER_CALORIC_CATEGORY_QUERY);
        return query.getResultList();
    }
}
