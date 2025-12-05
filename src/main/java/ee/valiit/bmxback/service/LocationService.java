package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.location.dto.LocationDto;
import ee.valiit.bmxback.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.persistence.location.LocationRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public void addLocation(@Valid LocationDto locationDto) {
    }

    public Location getValidLocation(Integer locationId) {
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new PrimaryKeyNotFoundException("locationId", locationId));
        return location;
    }
}
