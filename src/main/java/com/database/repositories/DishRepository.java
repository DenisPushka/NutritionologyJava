package com.database.repositories;

import com.database.implementers.DishImplementer;
import com.database.interfaces.IDishRepository;
import com.models.Dish;

/**
 * Репозиторий для запросов к таблице "Блюдо" (Dish), СИ (MS), рецепт (Recipe) и продукт блюдо Мап.
 * */
public class DishRepository implements IDishRepository {

    private DishImplementer dishImplementer;

    public DishRepository(DishImplementer dishImplementer) {
        this.dishImplementer = dishImplementer;
    }

    @Override
    public Dish AddDish(Dish dish) {
        return null;
    }
}
