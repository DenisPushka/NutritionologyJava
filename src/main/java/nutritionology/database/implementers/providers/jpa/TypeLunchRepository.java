package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.TypeLunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Date 03.02.2024
 */
@Repository
public interface TypeLunchRepository extends JpaRepository<TypeLunch, UUID> {

    TypeLunch getTypeLunchByName(String name);

}
