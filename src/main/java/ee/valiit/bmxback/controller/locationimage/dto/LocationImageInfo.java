package ee.valiit.bmxback.controller.locationimage.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.bmxback.persistence.locationimage.LocationImage}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationImageInfo implements Serializable {
    private Integer id;
    private Integer locationId;

    @NotNull
    private byte[] imageData;
}