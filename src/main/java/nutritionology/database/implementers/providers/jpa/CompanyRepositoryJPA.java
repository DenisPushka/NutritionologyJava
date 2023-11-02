package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.user.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepositoryJPA extends JpaRepository<Company, UUID> {
}
