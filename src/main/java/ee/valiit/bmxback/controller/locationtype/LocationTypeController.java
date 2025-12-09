package ee.valiit.bmxback.controller.locationtype;

import ee.valiit.bmxback.controller.locationtype.dto.LocationTypeInfo;
import ee.valiit.bmxback.service.LocationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationTypeController {
    private final LocationTypeService locationTypeService;

    @GetMapping("/location-types")
    public List<LocationTypeInfo> findLocationTypes() {
        List<LocationTypeInfo> locationTypes = locationTypeService.findLocationTypes();
        return locationTypes;

    }

}
