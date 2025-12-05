package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.locationimage.dto.LocationImageInfo;
import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.persistence.locationimage.LocationImageMapper;
import ee.valiit.bmxback.persistence.locationimage.LocationImageRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationImageService {
    private final LocationImageRepository locationImageRepository;
    private final LocationImageMapper locationImageMapper;
    private final LocationService locationService;

    public void addLocationImage(LocationImageInfo locationImageInfo) {
        Location location = locationService.getValidLocation(locationImageInfo.getLocationId());

        //Todo vaja teha bytes converter - set Location Image Data String to Bytes ja kaasa anna image Data
    }
}
