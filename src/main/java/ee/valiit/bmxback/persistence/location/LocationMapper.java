package ee.valiit.bmxback.persistence.location;

import ee.valiit.bmxback.controller.location.dto.LocationDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {


    @Mapping(source = "locationName", target = "name")
    @Mapping(source = "locationAddress", target = "address")
    @Mapping(source = "locationLng", target = "lng")
    @Mapping(source = "locationLat", target = "lat")
    @Mapping(source = "locationDescription", target = "description")
//    @Mapping(source = "", target = "status") motlen veel
//    @Mapping(source = "", target = "averageRating") //praegu ei taida
//    @Mapping(source = "", target = "createdAt") // vaatan parast
    Location toLocation(LocationDto locationDto);

}