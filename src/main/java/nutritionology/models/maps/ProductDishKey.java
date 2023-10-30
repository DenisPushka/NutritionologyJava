package nutritionology.models.maps;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

/**
 *  */
@Embeddable
public class ProductDishKey implements Serializable {

    @Column(name = "product_id")
    private UUID productId;

    @Column(name = "dish_id")
    private UUID dishId;

    // region get && set
    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public UUID getDishId() {
        return dishId;
    }

    public void setDishId(UUID dishId) {
        this.dishId = dishId;
    }

    // endregion
}
