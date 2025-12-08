package ee.valiit.bmxback.persistence.tag;

import ee.valiit.bmxback.controller.tag.dto.TagDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper {
    @Mapping(source = "tagName", target = "name")
    Tag toEntity(TagDto tagDto);

    @Mapping(source = "name", target = "tagName")
    TagDto toDto(Tag tag);

    List<Tag> toTags(List<TagDto> tagDtos);

    List<TagDto> toTagDtos(List<Tag> tags);
}