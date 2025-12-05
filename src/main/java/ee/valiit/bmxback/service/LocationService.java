package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.location.dto.LocationDto;
import ee.valiit.bmxback.persistence.county.County;
import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.persistence.location.LocationMapper;
import ee.valiit.bmxback.persistence.location.LocationRepository;
import ee.valiit.bmxback.persistence.locationtype.LocationType;
import ee.valiit.bmxback.persistence.user.User;
import jakarta.validation.Valid;
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
        User user = userService.getValidUser(userId);
        LocationType locationType = locationTypeService.getValidLocationType(locationDto.getLocationTypeId());
        County county = countyService.getValidCounty(locationDto.getCountyId());

        boolean locationExists = locationRepository.locationExistsBy(locationDto.getLocationName());


        Location location = locationMapper.toLocation(locationDto);
        location.setLocationType(locationType);
        location.setUser(user);
        location.setCounty(county);
        locationRepository.save(location);
    }

}

