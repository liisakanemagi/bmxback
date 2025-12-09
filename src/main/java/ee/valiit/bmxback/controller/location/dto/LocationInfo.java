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
public class LocationInfo implements Serializable {
    private Integer locationId;
    private String locationName;
    private BigDecimal locationAverageRating;
    private String locationAddress;
    private String typeColorCode;
    private String countyName;
    private String locationImageData;
    private Boolean isInFavourites;
}