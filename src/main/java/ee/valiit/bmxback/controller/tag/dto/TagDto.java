package ee.valiit.bmxback.controller.tag.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.bmxback.persistence.tag.Tag}
 */
@Data
public class TagDto implements Serializable {

    @NotNull
    private Integer tagId;

    @NotNull
    @Size(max = 20)
    private String tagName;
}