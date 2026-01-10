package ee.valiit.bmxback.controller.favoritelocation;

import ee.valiit.bmxback.service.FavoriteLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FavoriteLocationController {

    private final FavoriteLocationService favoriteLocationService;

    @PostMapping("/favorite/location")
    public Integer addFavoriteLocation(@RequestParam Integer userId, @RequestParam Integer locationId){
        return favoriteLocationService.handleAddFavoriteLocation(userId, locationId);
    }
@DeleteMapping("/favorite/location")
    public void removeFavoriteLocation(@RequestParam Integer userId, @RequestParam Integer locationId){
       favoriteLocationService.removeFavouriteLocation(userId, locationId);
}

}
