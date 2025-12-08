package ee.valiit.bmxback.persistence.locationtag;

import ee.valiit.bmxback.controller.locationtag.dto.LocationTagDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationTagMapper {
    @Mapping(source = "tagName", target = "tag.name")
    @Mapping(source = "locationId", target = "location.id")
    LocationTag toEntity(LocationTagDto locationTagDto);

    @InheritInverseConfiguration(name = "toEntity")
    LocationTagDto toDto(LocationTag locationTag);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LocationTag partialUpdate(LocationTagDto locationTagDto, @MappingTarget LocationTag locationTag);
}