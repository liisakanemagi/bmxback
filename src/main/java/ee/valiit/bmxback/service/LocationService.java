package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.location.dto.LocationDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    public void addLocation(@Valid LocationDto locationDto) {
    }
}
