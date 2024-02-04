package nutritionology.models.dictionaries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nutritionology.models.Dish;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Фото.
 */
@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "photo_id", length = 36, nullable = false, updatable = false)
    private UUID photo_id;

    /**
     * Значение.
     */
    @Column(name = "photo_name")
    private String photoName;

    /**
     * Блюдо.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
    @JsonIgnore
    private Dish dish;

    // region get && set

    public UUID getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(UUID photo_id) {
        this.photo_id = photo_id;
    }

    /**
     * Значение.
     */
    public String getPhotoName() {
        return photoName;
    }

    /**
     * Значение.
     */
    public void setPhotoName(String photoName) {
        this.photoName = photoName;
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

    // endregion
}
