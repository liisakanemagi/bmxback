package ee.valiit.bmxback.controller.locationtag;

import ee.valiit.bmxback.controller.locationtag.dto.LocationTagDto;
//  import ee.valiit.bmxback.service.locationtag.LocationTagService;
import ee.valiit.bmxback.service.LocationTagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class LocationTagController {

    private final LocationTagService locationTagService;

    @PostMapping("/location/tag")
    public void addLocationTag(@RequestParam Integer locationId, @RequestParam Integer tagId) {
        locationTagService.addLocationTag(locationId, tagId);
    }
}
