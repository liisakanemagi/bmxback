package ee.valiit.bmxback.controller.locationimage;

import ee.valiit.bmxback.controller.locationimage.dto.LocationImageDto;
import ee.valiit.bmxback.service.LocationImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LocationImageController {


    private final LocationImageService locationImageService;

    @PostMapping("/location/image")
    public void addLocationImage(@RequestBody @Valid LocationImageDto locationImageDto) {
        locationImageService.addLocationImage(locationImageDto);
    }
    @GetMapping("/location/image")
    public void findLocationImage(@RequestParam @Valid Integer locationId){

    }
}
