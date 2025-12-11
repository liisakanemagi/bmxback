package ee.valiit.bmxback.persistence.locationtype;

import ee.valiit.bmxback.controller.locationtype.dto.LocationTypeInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationTypeMapper {


    @Mapping(source = "id" ,target = "locationTypeId")
    @Mapping(source = "name" ,target = "locationTypeName")
    @Mapping(source = "colorCode" ,target = "locationTypeColorCode")
    @Mapping(constant = "true",target = "isSelected")
    LocationTypeInfo toLocationTypInfo(LocationType locationType);

    List<LocationTypeInfo> toLocationTypeInfos(List<LocationType> locationTypes);
}

