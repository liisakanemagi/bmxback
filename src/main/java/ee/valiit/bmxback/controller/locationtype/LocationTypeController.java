package ee.valiit.bmxback.controller.locationtype;

import ee.valiit.bmxback.service.LocationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class LocationTypeController {


    private final LocationTypeService locationTypeService;

    @GetMapping("/new-location")

    public void findLocationType() {
        locationTypeService.findLocationTypes();
    }
}
