package nutritionology.controllers;

import nutritionology.models.dictionaries.Product;
import nutritionology.models.maps.ProductMRItem;
import nutritionology.services.interfaces.ProductServiceInterface;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceInterface productServiceInterface;


    public ProductController(ProductServiceInterface productServiceInterface) {
        this.productServiceInterface = productServiceInterface;
    }

    /**
     * Добавление продукта.
     *
     * @param product Добавляемый продукт.
     */
    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productServiceInterface.addProduct(product);
    }

    /**
     * Добавление информации о продукте.
     *
     * @param productMRItems Добавляемая информация.
     */
    @PostMapping("/addProductMrItems")
    public void addProductMrItems(@RequestBody ProductMRItem[] productMRItems) {
        productServiceInterface.addProductMrItems(productMRItems);
    }

    /**
     * Получение всех продуктов.
     *
     * @return Массив пролуктов.
     */
    @GetMapping("/products")
    public ResponseEntity<Product[]> getProducts() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        return new ResponseEntity<>(productServiceInterface.getAllProducts(), headers, HttpStatus.OK);
    }

    @GetMapping("/check")
    public boolean checkController() {
        return true;//new ResponseEntity(true, HttpStatus.OK);
    }
}
