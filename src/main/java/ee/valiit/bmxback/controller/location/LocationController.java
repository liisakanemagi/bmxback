package ee.valiit.bmxback.controller.location;

import ee.valiit.bmxback.controller.location.dto.LocationDto;
import ee.valiit.bmxback.controller.location.dto.LocationInfo;
import ee.valiit.bmxback.infrastructure.error.ApiError;
import ee.valiit.bmxback.persistence.location.Location;
import ee.valiit.bmxback.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/location")
    @Operation(summary = "Uue asukoha lisamine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sõidukoht on juba olemas (errorCode 113)", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public Integer addLocation(@RequestBody @Valid LocationDto locationDto, @RequestParam Integer userId) {
        Location location = locationService.addLocation(locationDto, userId);
        return location.getId();
    }

    @GetMapping("/locations/filtered")
    public List<LocationInfo> findFilteredLocations(@RequestParam Integer userId, @RequestParam Integer countyId, @RequestParam List<Integer> locationTypeIds, @RequestParam Integer tagId) {
        return locationService.findFilteredLocations(userId, countyId, locationTypeIds, tagId);
    }

    @GetMapping("/locations/{locationId}")
    public void getLocationById(@PathVariable Integer locationId){
        locationService.getLocationById(locationId);
    }
}