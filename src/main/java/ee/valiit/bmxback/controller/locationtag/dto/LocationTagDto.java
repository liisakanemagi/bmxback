package ee.valiit.bmxback.controller.locationtag.dto;

import ee.valiit.bmxback.persistence.locationtag.LocationTag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.io.Serializable;

/**
 * DTO for {@link LocationTag}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationTagDto implements Serializable {
    private Integer locationId;
    private Integer tagId;
    private String tagName;
}