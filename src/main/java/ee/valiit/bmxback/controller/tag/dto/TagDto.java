package ee.valiit.bmxback.controller.tag.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.bmxback.persistence.tag.Tag}
 */
@Value
public class TagDto implements Serializable {
    @NotNull
    @Size(max = 20)
    String tagName;
}