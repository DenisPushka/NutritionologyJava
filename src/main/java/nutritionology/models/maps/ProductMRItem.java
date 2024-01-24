package nutritionology.models.maps;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import nutritionology.models.dictionaries.MRItem;
import nutritionology.models.dictionaries.Product;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Продукт и МР элемент.
 */
@Entity
@Table(name = "product_mr_item")
public class ProductMRItem {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "product_mr_item_id", length = 36, nullable = false, updatable = false)
    private UUID productMRItemId;

    /**
     * Продукт.
     */
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
//    @JsonIgnore
    private Product product;

    /**
     * МР элемент.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mr_item_id", nullable = false)
//    @JsonIgnore
    private MRItem mrItem;

    /**
     * Информация. Пищевая ценность.
     */
    @Column(name = "food_value")
    private double foodValue;

    /**
     * Химическая ценность.
     */
    @Column(name = "chemical_value")
    private double chemicalValue;

    // region get and set

    public UUID getProductMRItemId() {
        return productMRItemId;
    }

    public void setProductMRItemId(UUID productMRItemId) {
        this.productMRItemId = productMRItemId;
    }

    /**
     * Продукт.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Продукт.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * МР элемент.
     */
    public MRItem getMrItem() {
        return mrItem;
    }

    /**
     * МР элемент.
     */
    public void setMrItem(MRItem mrItem) {
        this.mrItem = mrItem;
    }

    /**
     * Информация. Пищевая ценность.
     */
    public double getFoodValue() {
        return foodValue;
    }

    /**
     * Информация. Пищевая ценность.
     */
    public void setFoodValue(double foodValue) {
        this.foodValue = foodValue;
    }

    /**
     * Химическая ценность.
     */
    public double getChemicalValue() {
        return chemicalValue;
    }

    /**
     * Химическая ценность.
     */
    public void setChemicalValue(double chemicalValue) {
        this.chemicalValue = chemicalValue;
    }

    // endregion
}
