package ee.valiit.bmxback.persistence.locationtag;

import ee.valiit.bmxback.controller.locationtag.dto.LocationTagDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationTagMapper {

}