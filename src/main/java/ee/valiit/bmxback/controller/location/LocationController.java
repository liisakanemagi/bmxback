package ee.valiit.bmxback.controller.location;

import ee.valiit.bmxback.controller.location.dto.LocationDto;
import ee.valiit.bmxback.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.persistence.user.User;
import ee.valiit.bmxback.persistence.user.UserRepository;
import ee.valiit.bmxback.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final UserRepository userRepository;

    @PostMapping("/new-location")

    public void addLocation(@RequestBody @Valid LocationDto locationDto, @RequestParam Integer userId) {


    };




}


