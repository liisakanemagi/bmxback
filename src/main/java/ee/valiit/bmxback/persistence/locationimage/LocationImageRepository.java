package ee.valiit.bmxback.persistence.locationimage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationImageRepository extends JpaRepository<LocationImage, Integer> {

    @Query("select l from LocationImage l where l.location.id = :locationId")
    List<LocationImage> findLocationImagesBy(Integer locationId);
}