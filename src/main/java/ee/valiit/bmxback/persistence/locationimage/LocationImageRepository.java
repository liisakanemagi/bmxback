package ee.valiit.bmxback.persistence.locationimage;

import ee.valiit.bmxback.controller.locationimage.dto.LocationImageInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationImageRepository extends JpaRepository<LocationImage, Integer> {

}