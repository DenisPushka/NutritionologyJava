package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.user.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepositoryJPA extends JpaRepository<Company, UUID> {
}
