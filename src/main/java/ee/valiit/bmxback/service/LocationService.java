package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.location.dto.LocationDto;
import ee.valiit.bmxback.infrastructure.error.Error;
import ee.valiit.bmxback.infrastructure.exception.ForbiddenException;
import ee.valiit.bmxback.persistence.county.County;
import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.persistence.location.LocationMapper;
import ee.valiit.bmxback.persistence.location.LocationRepository;
import ee.valiit.bmxback.persistence.locationtype.LocationType;
import ee.valiit.bmxback.persistence.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final UserService userService;
    private final LocationTypeService locationTypeService;
    private final CountyService countyService;
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public void addLocation(LocationDto locationDto, Integer userId) {
        validateLocationNameIsAvailable(locationDto);

        User user = userService.getValidUser(userId);
        LocationType locationType = locationTypeService.getValidLocationType(locationDto.getLocationTypeId());
        County county = countyService.getValidCounty(locationDto.getCountyId());

        Location location = locationMapper.toLocation(locationDto);
        location.setUser(user);
        location.setLocationType(locationType);
        location.setCounty(county);
        locationRepository.save(location);
    }

    private void validateLocationNameIsAvailable(LocationDto locationDto) {
        boolean locationExists = locationRepository.locationExistsBy(locationDto.getLocationName());
        if (locationExists) {
            throw new ForbiddenException(Error.LOCATION_NAME_UNAVAILABLE.getMessage(), Error.LOCATION_NAME_UNAVAILABLE.getErrorCode());
        }
    }

}

