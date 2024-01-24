package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ActivityRepositoryJPA extends JpaRepository<Activity, UUID> {

    /**
     * Получение калорий, белка, жиров и калорий по возрасту и полу.
     *
     * @param age      возраст.
     * @param name     название КФУ (номер, но String).
     * @param genderId пол.
     * @return Список list[int].
     */
    @Query(nativeQuery = true, value = "SELECT * FROM DBO.GetActivityWithParams(:age, :name, :gender_id)")
    List<Object[]> GetPPFCFromActivity(@Param("age") int age, @Param("name") String name,
                                       @Param("gender_id") String genderId);
}
