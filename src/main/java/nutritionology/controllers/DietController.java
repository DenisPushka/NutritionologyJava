package nutritionology.controllers;

import nutritionology.models.Diet;
import nutritionology.services.implementers.DietService;
import nutritionology.services.interfaces.DietServiceInterface;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * @Date 11.02.2024
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/diet")
public class DietController {
    private final Logger log = Logger.getLogger(DietController.class.getName());
    private final DietServiceInterface dietService;

    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<Diet> getDiet(@RequestParam String id) {
        log.info(String.format("Get diet by id = %s", id));

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");

        return new ResponseEntity<>(dietService.getDietById(id), headers, HttpStatus.OK);
    }
}
