package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.locationimage.dto.LocationImageInfo;
import ee.valiit.bmxback.infrastructure.util.BytesConverter;
import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.persistence.locationimage.LocationImage;
import ee.valiit.bmxback.persistence.locationimage.LocationImageMapper;
import ee.valiit.bmxback.persistence.locationimage.LocationImageRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationImageService {
    private final LocationImageRepository locationImageRepository;
    private final LocationImageMapper locationImageMapper;
    private final LocationService locationService;

    public void addLocationImage(LocationImageInfo locationImageInfo) {

        Location location = locationService.getValidLocation(locationImageInfo.getLocationId());
        LocationImage locationImage = new LocationImage();
        locationImage.setImageData(BytesConverter.stringToBytes(locationImageInfo.getLocationImageData()));
        locationImage.setLocation(location);
        locationImageRepository.save(locationImage);
    }

    public List<LocationImageInfo> getLocationImages(Integer locationId){
        List<LocationImage> locationImages = locationImageRepository.findByLocationId(locationId);
        return locationImageMapper.toLocationImageInfos(locationImages);

    }



}
