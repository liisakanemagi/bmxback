package ee.valiit.bmxback.persistence.locationrating;

import ee.valiit.bmxback.persistence.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface LocationRatingRepository extends JpaRepository<LocationRating, Integer> {


    @Query("select avg(l.rating) from LocationRating l where l.location.id = :locationId")
    BigDecimal getAverageRatingByLocation(Integer locationId);



}