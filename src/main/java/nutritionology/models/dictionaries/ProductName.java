package nutritionology.models.dictionaries;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Название продукта.
 */
@Entity
@Table(name = "product_name")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductName {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "product_name_id", length = 36, nullable = false, updatable = false)
    private UUID productNameId;

    /**
     * Название продукта.
     */
    @Column(name = "name", unique = true)
    @NotEmpty
    private String name;

    /**
     * Продукты.
     */
    @OneToMany(mappedBy = "productName", fetch = FetchType.LAZY)
    private Set<Product> products;
}
