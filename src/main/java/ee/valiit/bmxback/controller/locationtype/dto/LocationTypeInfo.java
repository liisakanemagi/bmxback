package ee.valiit.bmxback.controller.locationtype.dto;

import ee.valiit.bmxback.persistence.locationtype.LocationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link LocationType}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationTypeInfo implements Serializable {
    private Integer locationTypeId;
    private String locationTypeName;
    private String locationTypeColorCode;
    private Boolean isSelected;
}