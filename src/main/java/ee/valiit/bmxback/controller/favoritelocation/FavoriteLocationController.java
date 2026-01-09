package ee.valiit.bmxback.controller.favoritelocation;

import ee.valiit.bmxback.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FavoriteLocationController {

    private final LocationService locationService;

    @PostMapping("/favorite/location")
    public Integer addFavoriteLocation(@RequestParam Integer userId, @RequestParam Integer locationId){
        return locationService.addFavoriteLocation(userId, locationId);
    }

}
