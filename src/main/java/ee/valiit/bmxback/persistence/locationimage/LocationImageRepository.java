package ee.valiit.bmxback.persistence.locationimage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationImageRepository extends JpaRepository<LocationImage, Integer> {

    List<LocationImage> findByLocationId(Integer locationId);
}