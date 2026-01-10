package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.location.dto.LocationInfo;
import ee.valiit.bmxback.infrastructure.error.Error;
import ee.valiit.bmxback.infrastructure.exception.DataNotFoundException;
import ee.valiit.bmxback.infrastructure.exception.ForbiddenException;
import ee.valiit.bmxback.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.bmxback.persistence.favoritelocation.FavoriteLocation;
import ee.valiit.bmxback.persistence.favoritelocation.FavoriteLocationRepository;
import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.persistence.location.LocationRepository;
import ee.valiit.bmxback.persistence.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteLocationService {

    private final FavoriteLocationRepository favoriteLocationRepository;
    private final UserService userService;
    private final LocationRepository locationRepository;

    public FavoriteLocation getValidFavoriteLocation(Integer userId, Integer locationId) {
        return favoriteLocationRepository.findByUserIdAndLocationId(userId, locationId)
                .orElseThrow(() -> new DataNotFoundException("Lemmikasukohta ei leitud", 123));
    }

    public void handleLocationsIsInFavourites(Integer userId, LocationInfo locationInfo) {
        if (!userId.equals(0)) {
            boolean locationIsInFavourites = favoriteLocationRepository.locationIsInFavourites(userId, locationInfo.getLocationId());
            locationInfo.setIsInFavourites(locationIsInFavourites);
        }
    }

    public Integer handleAddFavoriteLocation(Integer userId, Integer locationId) {
        User user = userService.getValidUser(userId);
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new PrimaryKeyNotFoundException("locationId", locationId));
        if (locationAlreadyInFavorites(userId, locationId)) {
            throw new ForbiddenException(Error.LOCATION_ALREADY_IN_FAVOURITES.getMessage(),
                    Error.LOCATION_ALREADY_IN_FAVOURITES.getErrorCode());
        }
        return addFavoriteLocation(location, user);
    }

    public void removeFavouriteLocation(Integer userId, Integer locationId) {
        FavoriteLocation favoriteLocation = getValidFavoriteLocation(userId, locationId);
        favoriteLocationRepository.delete(favoriteLocation);
    }

    private boolean locationAlreadyInFavorites(Integer userId, Integer locationId) {
        return favoriteLocationRepository.locationIsInFavourites(userId, locationId);
    }

    private Integer addFavoriteLocation(Location location, User user) {
        FavoriteLocation favoriteLocation = new FavoriteLocation();
        favoriteLocation.setLocation(location);
        favoriteLocation.setUser(user);
        favoriteLocationRepository.save(favoriteLocation);
        return favoriteLocation.getId();
    }
}