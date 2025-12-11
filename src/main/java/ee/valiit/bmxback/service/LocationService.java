package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.location.dto.LocationDto;
import ee.valiit.bmxback.controller.location.dto.LocationInfo;
import ee.valiit.bmxback.infrastructure.error.Error;
import ee.valiit.bmxback.infrastructure.exception.ForbiddenException;
import ee.valiit.bmxback.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.bmxback.infrastructure.util.BytesConverter;
import ee.valiit.bmxback.persistence.county.County;
import ee.valiit.bmxback.persistence.favoritelocation.FavoriteLocationRepository;
import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.persistence.location.LocationMapper;
import ee.valiit.bmxback.persistence.location.LocationRepository;
import ee.valiit.bmxback.persistence.locationimage.LocationImage;
import ee.valiit.bmxback.persistence.locationimage.LocationImageRepository;
import ee.valiit.bmxback.persistence.locationrating.LocationRatingRepository;
import ee.valiit.bmxback.persistence.locationtag.LocationTagRepository;
import ee.valiit.bmxback.persistence.locationtype.LocationType;
import ee.valiit.bmxback.persistence.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final UserService userService;
    private final LocationTypeService locationTypeService;
    private final CountyService countyService;
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    private final LocationTagRepository locationTagRepository;
    private final LocationRatingRepository locationRatingRepository;
    private final LocationImageRepository locationImageRepository;
    private final FavoriteLocationRepository favoriteLocationRepository;


    public Location getValidLocation(Integer locationId) {
        return locationRepository.findById(locationId)
                .orElseThrow(() -> new PrimaryKeyNotFoundException("locationId", locationId));
    }

    public Location addLocation(LocationDto locationDto, Integer userId) {
        validateLocationNameIsAvailable(locationDto);
        return createAndSaveLocation(locationDto, userId);
    }

    public LocationDto getLocation(Integer locationId) {
        Location location = getValidLocation(locationId);
        return locationMapper.toLocationDto(location);
    }

    public List<LocationInfo> findFilteredLocations(Integer userId, Integer countyId, List<Integer> typeIds, Integer tagId) {
        List<Location> locations = getLocations(countyId, typeIds, tagId);
        List<LocationInfo> locationInfos = locationMapper.toLocationInfos(locations);
        handleAddOtherInfoToLocationInfos(userId, locationInfos);
        return locationInfos;
    }

    private void validateLocationNameIsAvailable(LocationDto locationDto) {
        boolean locationExists = locationRepository.locationExistsBy(locationDto.getLocationName());
        if (locationExists) {
            throw new ForbiddenException(Error.LOCATION_NAME_UNAVAILABLE.getMessage(), Error.LOCATION_NAME_UNAVAILABLE.getErrorCode());
        }
    }

    private Location createAndSaveLocation(LocationDto locationDto, Integer userId) {
        Location location = createLocation(locationDto, userId);
        return locationRepository.save(location);
    }

    private Location createLocation(LocationDto locationDto, Integer userId) {
        User user = userService.getValidUser(userId);
        LocationType locationType = locationTypeService.getValidLocationType(locationDto.getLocationTypeId());
        County county = countyService.getValidCounty(locationDto.getCountyId());

        Location location = locationMapper.toLocation(locationDto);
        location.setUser(user);
        location.setLocationType(locationType);
        location.setCounty(county);
        return location;
    }

    private List<Location> getLocations(Integer countyId, List<Integer> typeIds, Integer tagId) {
        List<Location> locations = locationRepository.findLocationsBy(countyId, typeIds);
        locations = handleFilterLocationsByTagId(locations, tagId);
        return locations;
    }

    private List<Location> handleFilterLocationsByTagId(List<Location> locations, Integer tagId) {
        if (!tagId.equals(0)) {

            ArrayList<Location> filteredList = new ArrayList<>();
            for (Location location : locations) {
                boolean locationTagExists = locationTagRepository.locationTagExistsBy(location, tagId);
                if (locationTagExists) {
                    filteredList.add(location);
                }
            }
            locations = filteredList;
        }
        return locations;
    }


    private void handleAddOtherInfoToLocationInfos(Integer userId, List<LocationInfo> locationInfos) {
        for (LocationInfo locationInfo : locationInfos) {
            handleAddLocationAverageRating(locationInfo);
            handleAddLocationImageData(locationInfo);
            handleAddIsInFavourites(userId, locationInfo);
        }
    }

    private void handleAddLocationAverageRating(LocationInfo locationInfo) {
        BigDecimal averageRating = locationRatingRepository.getAverageRatingByLocation(locationInfo.getLocationId());
        if (averageRating == null) {
            locationInfo.setLocationAverageRating(BigDecimal.valueOf(0));
        } else {
            locationInfo.setLocationAverageRating(averageRating);
        }
    }

    private void handleAddLocationImageData(LocationInfo locationInfo) {
        Optional<LocationImage> optionalLocationImage = locationImageRepository.findFirstByLocationId(locationInfo.getLocationId());
        if (optionalLocationImage.isPresent()) {
            byte[] imageDataAsBytes = optionalLocationImage.get().getImageData();
            locationInfo.setLocationImageData(BytesConverter.bytesToString(imageDataAsBytes));
        }
    }

    private void handleAddIsInFavourites(Integer userId, LocationInfo locationInfo) {
        if (!userId.equals(0)) {
            boolean locationIsInFavourites = favoriteLocationRepository.locationIsInFavouritesBy(userId, locationInfo.getLocationId());
            locationInfo.setIsInFavourites(locationIsInFavourites);
        }
    }

}

