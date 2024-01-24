package nutritionology.models.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Физическое лицо.
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "customer_id", length = 36, nullable = false, updatable = false)
    private UUID customerId;

    /**
     * Имя.
     */
    @Column(name = "name")
    @NotEmpty
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    /**
     * Фамилия.
     */
    @Column(name = "last_name")
    @NotEmpty
    @Size(min = 2, max = 30, message = "LastName should be between 2 and 30 characters")
    private String lastName;

    /**
     * Пользователь.
     */
    @OneToOne(mappedBy = "customer")
    private User user;

    // region get and set

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    /**
     * Имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Фамилия.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Фамилия.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Пользователь.
     */
    public User getUser() {
        return user;
    }

    /**
     * Пользователь.
     */
    public void setUser(User user) {
        this.user = user;
    }

    // endregion
}
