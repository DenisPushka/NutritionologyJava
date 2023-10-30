package nutritionology.models.dictionaries;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Название продукта.
 */
@Entity
@Table(name = "product_name")
public class ProductName {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "product_name_id", length = 36, nullable = false, updatable = false)
    private UUID productNameId;

    /**
     * Название продукта.
     */
    @Column(name = "name")
    private String name;

    /**
     * Продукты.
     */
    @OneToMany(mappedBy = "productName")
    private Set<Product> products;

    // region get and set

    public UUID getProductNameId() {
        return productNameId;
    }

    public void setProductNameId(UUID productNameId) {
        this.productNameId = productNameId;
    }

    /**
     * Название продукта.
     */
    public String getName() {
        return name;
    }

    /**
     * Название продукта.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Продукты.
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Продукты.
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    // endregion

}
