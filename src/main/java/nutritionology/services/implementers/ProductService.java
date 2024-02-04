package nutritionology.services.implementers;

import nutritionology.database.implementers.providers.jpa.MRItemRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.ProductMRItemJPA;
import nutritionology.database.implementers.providers.jpa.ProductRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.ProductRepositoryNameJPA;
import nutritionology.models.dictionaries.Product;
import nutritionology.models.dictionaries.ProductName;
import nutritionology.models.maps.ProductMRItem;
import nutritionology.services.interfaces.ProductServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductServiceInterface {

    private final ProductRepositoryNameJPA productRepositoryNameJPA;
    private final ProductRepositoryJPA productRepositoryJPA;

    private final ProductMRItemJPA productMRItemJPA;

    private final MRItemRepositoryJPA mrItemRepositoryJPA;

    public ProductService(ProductRepositoryNameJPA productRepositoryNameJPA, ProductRepositoryJPA productRepositoryMapJPA, ProductMRItemJPA productMRItemJPA, MRItemRepositoryJPA mrItemRepositoryJPA) {
        this.productRepositoryNameJPA = productRepositoryNameJPA;
        this.productRepositoryJPA = productRepositoryMapJPA;
        this.productMRItemJPA = productMRItemJPA;
        this.mrItemRepositoryJPA = mrItemRepositoryJPA;
    }

    @Override
    public ProductName addProductName(String name) {
        if (productRepositoryNameJPA.findFirstByName(name) == null) {
            ProductName productName = new ProductName();
            productName.setName(name);
            productRepositoryNameJPA.save(productName);
        }

        return productRepositoryNameJPA.findFirstByName(name);
    }

    @Override
    public ProductName[] getProductNames() {
        return new ProductName[0];
    }

    @Override
    public Product addProduct(Product product) {
        product.setProductName(addProductName(product.getProductName().getName()));
        Product productCurrent = productRepositoryJPA.findFirstByProductFullName(product.getProductFullName());

        if (productCurrent != null) {
            return productCurrent;
        }

        productRepositoryJPA.save(product);

        return productRepositoryJPA.findFirstByProductFullName(product.getProductFullName());
    }

    @Override
    public ProductMRItem[] addProductMrItems(ProductMRItem[] productMRItems) {
        addProduct(productMRItems[0].getProduct());

        for (ProductMRItem currentProduct: productMRItems) {
            currentProduct.setMrItem(mrItemRepositoryJPA.findById(currentProduct.getMrItem().getMrItemId()).get());
            currentProduct.setProduct(productRepositoryJPA.findFirstByProductFullName(currentProduct.getProduct().getProductFullName()));
            productMRItemJPA.save(currentProduct);
        }

        return productMRItemJPA.findAll().toArray(new ProductMRItem[0]);
    }

    @Override
    public Product[] getAllProducts() {
        return productRepositoryJPA.findAll().toArray(new Product[0]);
    }

    @Override
    public Product[] getProductForName(ProductName productName) {
        return new Product[0];
    }
}
