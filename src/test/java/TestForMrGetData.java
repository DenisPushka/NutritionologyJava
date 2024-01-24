import nutritionology.Application;
import nutritionology.models.dictionaries.ProductName;
import nutritionology.services.implementers.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Date 08.01.2024
 */
@SpringBootTest(classes = Application.class)
public class TestForMrGetData {
    @Test
    void exampleTest(@Autowired ProductService productService){
        ProductName a = productService.addProductName("Мясо");
        var c = 4;
    }
}
