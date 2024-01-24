package nutritionology.controllers;

import nutritionology.models.dictionaries.Product;
import nutritionology.models.maps.ProductMRItem;
import nutritionology.services.interfaces.ProductServiceInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
