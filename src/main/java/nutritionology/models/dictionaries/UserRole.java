package nutritionology.models.dictionaries;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import nutritionology.models.Parameter;
import nutritionology.models.user.User;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Роль пользователя.
 */
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "user_role_id", length = 36, nullable = false, updatable = false)
    private UUID userRoleId;

    /**
     * Название.
     */
    @Column(name = "name")
    @NotEmpty
    private String name;

    /**
     * Параметр.
     */
    @OneToMany(mappedBy = "userRole")
    private Set<User> users;

    // region get and set

    public UUID getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UUID userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * Название.
     */
    public String getName() {
        return name;
    }

    /**
     * Название.
     */
    public void setName(String name) {
        this.name = name;
    }

    // endregion
}
