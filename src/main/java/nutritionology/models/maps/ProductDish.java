package nutritionology.models.maps;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import nutritionology.models.Dish;
import nutritionology.models.dictionaries.MS;
import nutritionology.models.dictionaries.Product;
import jakarta.persistence.*;

/**
 * Промежуточная таблица для хранения продуктов в блюде.
 */
@Entity
@Table(name = "product_dish")
public class ProductDish {

    @EmbeddedId
    private ProductDishKey productDishId;

    /**
     * Продукт.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Блюдо.
     */
    @ManyToOne
    @MapsId("dishId")
    @JoinColumn(name = "dish_id")
    @JsonIgnore
    private Dish dish;

    /**
     * Вес.
     */
    @Column(name = "weight")
    private double weight;

    /**
     * СИ.
     */
    @ManyToOne
    @JoinColumn(name = "ms_id", nullable = false)
    private MS ms;

    // region get and set

    public ProductDishKey getProductDishId() {
        return productDishId;
    }

    public void setProductDishId(ProductDishKey productDishId) {
        this.productDishId = productDishId;
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
     * Блюдо.
     */
    public Dish getDish() {
        return dish;
    }

    /**
     * Блюдо.
     */
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    /**
     * Вес.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Вес.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * СИ.
     */
    public MS getMs() {
        return ms;
    }

    /**
     * СИ.
     */
    public void setMs(MS ms) {
        this.ms = ms;
    }

    // endregion
}
