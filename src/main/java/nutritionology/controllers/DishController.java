package nutritionology.controllers;

import nutritionology.models.Dish;
import nutritionology.services.interfaces.DishServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для взаимодейсвия с моедлью "Блюдо".
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    private final DishServiceInterface dishServiceInterface;

    public DishController(DishServiceInterface dishServiceInterface) {
        this.dishServiceInterface = dishServiceInterface;
    }

    @PostMapping("/add")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
        try {
            return new ResponseEntity<>(dishServiceInterface.addDish(dish), HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
