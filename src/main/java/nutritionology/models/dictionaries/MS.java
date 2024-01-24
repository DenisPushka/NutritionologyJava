package nutritionology.models.dictionaries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.PreDestroy;
import nutritionology.models.maps.ProductDish;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Set;
import java.util.UUID;

/**
 * Система измерений (СИ).
 */
@Entity
@Table(name = "ms")
public class MS {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "ms_id", length = 36, nullable = false, updatable = false)
    private UUID msId;

    /**
     * Короткое название.
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * Полное название.
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * Продукты.
     */
    @OneToMany(mappedBy = "ms")
    @JsonIgnore
    private Set<ProductDish> productDishes;

    /**
     * МР Элементы.
     */
    @OneToMany(mappedBy = "ms")
    @JsonIgnore
    private Set<MRItem> mrItems;

    // region gets and sets

    public UUID getMsId() {
        return msId;
    }

    public void setMsId(UUID msId) {
        this.msId = msId;
    }

    /**
     * Короткое название.
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Короткое название.
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Полное название.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Полное название.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Продукты.
     */
    public Set<ProductDish> getProductDishes() {
        return productDishes;
    }

    /**
     * Продукты.
     */
    public void setProductDishes(Set<ProductDish> productDishes) {
        this.productDishes = productDishes;
    }

    /**
     * МР Элементы.
     */
    public Set<MRItem> getMrItems() {
        return mrItems;
    }

    /**
     * МР Элементы.
     */
    public void setMrItems(Set<MRItem> mrItems) {
        this.mrItems = mrItems;
    }

    // endregion
}
