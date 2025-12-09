package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.locationimage.dto.LocationImageDto;
import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.persistence.locationimage.LocationImage;
import ee.valiit.bmxback.persistence.locationimage.LocationImageMapper;
import ee.valiit.bmxback.persistence.locationimage.LocationImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationImageService {
    private final LocationImageRepository locationImageRepository;
    private final LocationImageMapper locationImageMapper;
    private final LocationService locationService;

    public void addLocationImage(LocationImageDto locationImageDto) {
        createAnsSaveLocationImage(locationImageDto);
    }

    private void createAnsSaveLocationImage(LocationImageDto locationImageDto) {
        LocationImage locationImage = createLocationImage(locationImageDto);
        locationImageRepository.save(locationImage);
    }

    private LocationImage createLocationImage(LocationImageDto locationImageDto) {
        Location location = locationService.getValidLocation(locationImageDto.getLocationId());
        LocationImage locationImage = locationImageMapper.toLocationImage(locationImageDto);
        locationImage.setLocation(location);
        return locationImage;
    }

    public List<LocationImageDto> findLocationImages(Integer locationId) {
        List<LocationImage> locationImages = locationImageRepository.findByLocationId(locationId);
        return locationImageMapper.toLocationImageDtos(locationImages);
    }

}
