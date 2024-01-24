package nutritionology.models.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import nutritionology.models.Parameter;
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
    @JoinColumn(name = "subscription_id", nullable = false)
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

    // region get and set

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /**
     * Фото.
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Фото.
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Подписка.
     */
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * Подписка.
     */
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    /**
     * Параметры для пользователя.
     */
    public Set<Parameter> getParameters() {
        return parameters;
    }

    /**
     * Параметры для пользователя.
     */
    public void setParameters(Set<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * Физ лицо.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Физ лицо.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Компания.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Компания.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Роль пользователя.
     */
    public UserRole getUserRole() {
        return userRole;
    }

    /**
     * Роль пользователя.
     */
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    /**
     * Почта, логин.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Почта, логин.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Хешированнный парооль.
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Хешированнный парооль.
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // endregion
}
