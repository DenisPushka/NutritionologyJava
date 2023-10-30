package nutritionology.controllers;

import nutritionology.database.implementers.providers.jpa.GenderRepositoryJPA;
import nutritionology.models.Dish;
import nutritionology.models.dictionaries.Gender;
import nutritionology.services.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для взаимодейсвия с моедлью "Блюдо".
 */
@RestController // TODO read about rest controller and just controller.
@RequestMapping("/dish")
public class DishController {

    private DishService dishService;

    private GenderRepositoryJPA genderRepositoryJPA;

    public DishController(DishService dishService, GenderRepositoryJPA genderRepositoryJPA) {
        this.dishService = dishService;
        this.genderRepositoryJPA = genderRepositoryJPA;
    }

    @GetMapping("/addGender")
    public ResponseEntity TestInsert(String shortName, String fullName){
        var gender = new Gender();
        gender.setShortName(shortName);
        gender.setFullName(fullName);
        genderRepositoryJPA.save(gender);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    /**
     * @param name Название блюда.
     * @return Искомое блюдо.
     */
    // TODO переопределить свой response entity.
    @GetMapping("/getDishForName")
    public ResponseEntity<Dish> GetDishForName(String name) {
        return new ResponseEntity<Dish>(dishService.GetDishForName(name), HttpStatus.ACCEPTED);
    }
}
