package ee.valiit.bmxback.persistence.tag;

import ee.valiit.bmxback.controller.tag.dto.TagInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper {

    @Mapping(source = "id", target = "tagId")
    @Mapping(source = "name", target = "tagName")
    TagInfo toTagInfo(Tag tag);

    List<TagInfo> toTagInfos(List<Tag> tags);
}