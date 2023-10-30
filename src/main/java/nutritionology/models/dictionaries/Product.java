package nutritionology.models.dictionaries;

import jakarta.persistence.*;
import nutritionology.models.Parameter;
import nutritionology.models.maps.ProductMRItem;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Продукт.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "product_id", length = 36, nullable = false, updatable = false)
    private UUID productId;

    /**
     * Название продукта.
     */
    @ManyToOne
    @JoinColumn(name = "product_name_id", nullable = false)
    private ProductName productName;

    /**
     * Полное название продукта.
     */
    @Column(name = "product_full_name")
    private String productFullName;

    /**
     * Параметр.
     */
    @ManyToMany(mappedBy = "likeProducts")
    private Set<Parameter> likeProducts;

    /**
     * Параметр.
     */
    @ManyToMany(mappedBy = "problemProducts")
    private Set<Parameter> problemProducts;

    /**
     * Свойство продукта.
     */
    @OneToMany(mappedBy = "product")
    private Set<ProductMRItem> productMRItems;

    // region get and set

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    /**
     * Название продукта.
     */
    public ProductName getProductName() {
        return productName;
    }

    /**
     * Название продукта.
     */
    public void setProductName(ProductName productName) {
        this.productName = productName;
    }

    /**
     * Полное название продукта.
     */
    public String getProductFullName() {
        return productFullName;
    }

    /**
     * Полное название продукта.
     */
    public void setProductFullName(String productFullName) {
        this.productFullName = productFullName;
    }

    /**
     * Параметр.
     */
    public Set<Parameter> getLikeProducts() {
        return likeProducts;
    }

    /**
     * Параметр.
     */
    public void setLikeProducts(Set<Parameter> parameterLike) {
        this.likeProducts = parameterLike;
    }

    /**
     * Параметр.
     */
    public Set<Parameter> getProblemProducts() {
        return problemProducts;
    }

    /**
     * Параметр.
     */
    public void setProblemProducts(Set<Parameter> parameterProblem) {
        this.problemProducts = parameterProblem;
    }

    /**
     * Свойство продукта.
     */
    public Set<ProductMRItem> getProductMRItems() {
        return productMRItems;
    }

    /**
     * Свойство продукта.
     */
    public void setProductMRItems(Set<ProductMRItem> productMRItems) {
        this.productMRItems = productMRItems;
    }

    // endregion
}
