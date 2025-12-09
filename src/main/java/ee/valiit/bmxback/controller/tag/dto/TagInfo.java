package ee.valiit.bmxback.controller.tag.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.bmxback.persistence.tag.Tag}
 */
@Data
public class TagInfo implements Serializable {

    @NotNull
    private Integer tagId;

    @NotNull
    @Size(max = 20)
    private String tagName;

}