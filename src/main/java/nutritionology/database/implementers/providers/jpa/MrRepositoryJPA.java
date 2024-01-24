package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.MR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MrRepositoryJPA extends JpaRepository<MR, UUID> {

    @Query(nativeQuery = true, value = "select * from dbo.GetDataFromPerson(:age, :gender)")
    List<Object[]> GetDataFromPerson(@Param("age") int age, @Param("gender") String shortGender);
}
