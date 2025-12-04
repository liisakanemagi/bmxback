package ee.valiit.bmxback.persistence.county;

import ee.valiit.bmxback.controller.county.dto.CountyInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountyMapper {

    @Mapping(source = "id", target = "locationId")
    @Mapping(source = "name", target = "countyName")
    @Mapping(source = "zoomLevel", target = "zoomLevel")
    @Mapping(source = "lng", target = "countyLng")
    @Mapping(source = "lat", target = "countyLat")
    CountyInfo toCountyInfo(County county);


}