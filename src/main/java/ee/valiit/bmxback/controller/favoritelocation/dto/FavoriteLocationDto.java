package ee.valiit.bmxback.controller.favoritelocation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.bmxback.persistence.favoritelocation.FavoriteLocation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteLocationDto implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer locationId;
}