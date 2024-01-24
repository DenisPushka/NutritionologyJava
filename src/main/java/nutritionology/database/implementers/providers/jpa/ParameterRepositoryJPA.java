package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParameterRepositoryJPA extends JpaRepository<Parameter, UUID> {
}
