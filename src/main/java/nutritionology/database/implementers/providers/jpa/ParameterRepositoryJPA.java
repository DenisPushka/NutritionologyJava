package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParameterRepositoryJPA extends JpaRepository<Parameter, UUID> {
}
