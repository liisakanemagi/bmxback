package ee.valiit.bmxback.persistence.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("select (count(l) > 0) from Location l where l.name = :locationName")
    boolean locationExistsBy(String locationName);

    @Query("""
            select l from Location l
            where (l.county.id = :countyId or :countyId = 0) and l.locationType.id in :locationTypeIds
            order by l.county.name, l.locationType.name""")
    List<Location> findLocationsBy(Integer countyId, List<Integer> locationTypeIds);


}

