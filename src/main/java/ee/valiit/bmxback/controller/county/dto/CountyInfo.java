package ee.valiit.bmxback.controller.county.dto;

import ee.valiit.bmxback.persistence.county.County;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link County}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountyInfo implements Serializable {
    private Integer locationId;
    @NotNull
    @Size(max = 255)
    private String countyName;
    private Integer zoomLevel;
    private BigDecimal countyLng;
    private BigDecimal countyLat;
}