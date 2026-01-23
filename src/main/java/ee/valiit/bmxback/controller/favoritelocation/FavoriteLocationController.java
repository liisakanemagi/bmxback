package ee.valiit.bmxback.controller.favoritelocation;

import ee.valiit.bmxback.controller.location.dto.LocationInfo;
import ee.valiit.bmxback.service.FavoriteLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FavoriteLocationController {

    private final FavoriteLocationService favoriteLocationService;

    @PostMapping("/favorite/location")
    public Integer addFavoriteLocation(@RequestParam Integer userId, @RequestParam Integer locationId){
        return favoriteLocationService.handleAddFavoriteLocation(userId, locationId);
    }

    @GetMapping("/favorite/locations")
    public List<LocationInfo> getFavoriteLocations(@RequestParam Integer userId){
        return favoriteLocationService.getFavoriteLocations(userId);
    }

    @DeleteMapping("/favorite/location")
    public void removeFavoriteLocation(@RequestParam Integer userId, @RequestParam Integer locationId){
       favoriteLocationService.removeFavouriteLocation(userId, locationId);
}

}
