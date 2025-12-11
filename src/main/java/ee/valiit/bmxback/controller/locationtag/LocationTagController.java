package ee.valiit.bmxback.controller.locationtag;

import ee.valiit.bmxback.controller.locationtag.dto.LocationTagDto;
//  import ee.valiit.bmxback.service.locationtag.LocationTagService;
import ee.valiit.bmxback.service.LocationTagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class LocationTagController {

    private final LocationTagService locationTagService;

    @PostMapping("/location/tag")
    public void addLocationTag(@RequestBody @Valid LocationTagDto locationTagDto) {
        locationTagService.addLocationTag(locationTagDto);
    }
}
