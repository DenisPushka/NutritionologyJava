package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, UUID> {

    @Query(nativeQuery = true, value = "select * from user_parent where email = ?1 and password_hash = ?2")
    User findFirstByEmail(String email, String password);
}
