package nutritionology.controllers;

import nutritionology.models.Dish;
import nutritionology.services.implementers.DishService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Контроллер для взаимодействия с моделью "Блюдо".
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/dish")
public class DishController {
    private final Logger log = Logger.getLogger(DishController.class.getName());

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping("/add")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
        try {
            log.info("Add dish!");

            MultiValueMap<String, String> headers = new HttpHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            headers.add("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");

            return new ResponseEntity<>(dishService.addDish(dish), headers, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
