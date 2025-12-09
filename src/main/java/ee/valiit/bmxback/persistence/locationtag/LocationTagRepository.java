package ee.valiit.bmxback.persistence.locationtag;

import ee.valiit.bmxback.persistence.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationTagRepository extends JpaRepository<LocationTag, Integer> {


    @Query("select (count(l) > 0) from LocationTag l where l.location = :location and l.tag.id = :tagId")
    boolean locationTagExistsBy(Location location, Integer tagId);
}