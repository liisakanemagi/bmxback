package ee.valiit.bmxback.persistence.locationtype;

import ee.valiit.bmxback.controller.locationtype.dto.LocationTypeInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationTypeMapper {


    @Mapping(source = "id" ,target = "locationTypeId")
    @Mapping(source = "name" ,target = "locationTypeName")
    @Mapping(source = "colorCode" ,target = "locationTypeColorCode")
    LocationTypeInfo locationTypInfo(LocationType locationType);
}

