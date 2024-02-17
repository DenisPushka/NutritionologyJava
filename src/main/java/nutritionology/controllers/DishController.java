package nutritionology.controllers;

import nutritionology.database.implementers.providers.jpa.PhotoRepositoryJPA;
import nutritionology.models.Dish;
import nutritionology.models.dictionaries.Photo;
import nutritionology.services.implementers.DishService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Контроллер для взаимодействия с моделью "Блюдо".
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dish")
public class DishController {

    @Value("${upload.path}")
    private String uploadPath;
    private final PhotoRepositoryJPA photoRepositoryJPA;

    private final Logger log = Logger.getLogger(DishController.class.getName());

    private final DishService dishService;

    public DishController(DishService dishService, PhotoRepositoryJPA photoRepositoryJPA) {
        this.dishService = dishService;
        this.photoRepositoryJPA = photoRepositoryJPA;
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

    @PostMapping("/add-photo-to-dish")
    public void addPhoto(@RequestBody MultipartFile file, @RequestParam("name") String name) {

        // todo вынести в сервис.
        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuid = UUID.randomUUID().toString();
            String resultName = uuid + "-" + file.getOriginalFilename();

            try {
                FileOutputStream fileJ = new FileOutputStream(uploadPath + "//" + resultName);
                fileJ.write(file.getBytes());

                fileJ.close();
                log.info("File has been written");
            } catch (IOException ex) {
                log.info(ex.getMessage());
            }

            Dish dish = dishService.getDishForName(name);
            photoRepositoryJPA.save(Photo.builder()
                            .dish(dish)
                            .photoName(resultName)
                    .build());
        }
    }

    @GetMapping
    public Dish getDishByName(@RequestParam("name")String name){
        return dishService.getDishForName(name);
    }
}
