package nutritionology.services;

import nutritionology.database.interfaces.DishRepositoryInterface;
import nutritionology.models.Dish;
import org.springframework.stereotype.Service;

/**
 * Сервис для блюд.
 * */
@Service
public class DishService {

    /**
     * Репозиторий для блюда.
     * */
    private DishRepositoryInterface dishRepositoryInterface;

    public DishService(DishRepositoryInterface dishRepositoryInterface) {
        this.dishRepositoryInterface = dishRepositoryInterface;
    }

    /**
     * Получение блюда по его имени.
     * @param name название блюда.
     * @return Блюдо.*/
    public Dish GetDishForName(String name)
    {
        return dishRepositoryInterface.GetDishForName(name);
    }
}
