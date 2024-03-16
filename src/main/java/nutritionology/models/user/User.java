package nutritionology.models.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import nutritionology.models.Diet;
import nutritionology.models.Parameter;
import nutritionology.models.dictionaries.MealTime;
import nutritionology.models.dictionaries.Subscription;
import nutritionology.models.dictionaries.UserRole;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Общий пользователь.
 */
@Entity
@Table(name = "user_parent")
@Data
public class User {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "user_id", length = 36, nullable = false, updatable = false)
    private UUID userId;

    /**
     * Фото.
     */
    @Column(name = "photo")
    private String photo;

    /**
     * Подписка.
     */
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    /**
     * Параметры для пользователя.
     */
    @ManyToMany
    @JoinTable(
            name = "user_parameter_map",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "parameter_id"))
    private Set<Parameter> parameters;

    /**
     * Физ лицо.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    /**
     * Компания.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;

    /**
     * Роль пользователя.
     */
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;

    /**
     * Почта, логин.
     */
    @Column(name = "email")
    @Email(message = "Email should be valid!")
    private String email;

    /**
     * Хешированнный парооль.
     */
    @Column(name = "password_hash")
    @NotEmpty(message = "Password is empty!")
    @Size(min = 5, message = "Size password minimum 5 sign")
    private String passwordHash;

    /**
     * Рационы.
     */
    @ManyToMany
    @JoinTable(
            name = "user_diet_map",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "diet_id", referencedColumnName = "diet_id"))
    private Set<Diet> diets;
}
