package ee.valiit.bmxback.controller.location.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link ee.valiit.bmxback.persistence.location.Location}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto implements Serializable {
    private Integer locationTypeId;

    private Integer countyId;

    @NotNull
    @Size(max = 255)
    private String locationName;

    @Size(max = 255)
    private String locationAddress;

    @NotNull
    private BigDecimal locationLng;

    @NotNull
    private BigDecimal locationLat;

    @Size(max = 1000)
    private String locationDescription;
}