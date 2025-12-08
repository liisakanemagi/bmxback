package ee.valiit.bmxback.controller.location;

import ee.valiit.bmxback.controller.location.dto.LocationDto;
import ee.valiit.bmxback.infrastructure.error.ApiError;
import ee.valiit.bmxback.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping("/location")
    @Operation(summary = "Uue asukoha lisamine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description ="Sõidukoht on juba olemas (errorCode 113)", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addLocation(@RequestBody @Valid LocationDto locationDto, @RequestParam Integer userId) {
        locationService.addLocation(locationDto, userId);
    }

}


