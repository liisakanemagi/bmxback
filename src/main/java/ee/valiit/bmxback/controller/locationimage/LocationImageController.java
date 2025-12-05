package ee.valiit.bmxback.controller.locationimage;

import ee.valiit.bmxback.controller.locationimage.dto.LocationImageInfo;
import ee.valiit.bmxback.service.LocationImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationImageController {


    private final LocationImageService locationImageService;

    @PostMapping("/location/image")
    public void addLocationImage(@RequestBody @Valid LocationImageInfo locationImageInfo) {
        locationImageService.addLocationImage(locationImageInfo);
    }
}
