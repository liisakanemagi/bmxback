package ee.valiit.bmxback.persistence.locationtype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationTypeRepository extends JpaRepository<LocationType, Integer> {
    @Query("select l from LocationType l where l.id = :locationTypeId and l.name = :locationTypeName and l.colorCode = :colorCode")
    List<LocationType> findLocationTypeInfosBy(Integer locationTypeId, String locationTypeName, String colorCode);

}