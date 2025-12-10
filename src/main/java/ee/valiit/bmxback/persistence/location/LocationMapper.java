package ee.valiit.bmxback.persistence.location;

import ee.valiit.bmxback.controller.location.dto.LocationDto;
import ee.valiit.bmxback.controller.location.dto.LocationInfo;
import org.mapstruct.*;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Instant.class})
public interface LocationMapper {

    @Mapping(source = "locationName", target = "name")
    @Mapping(source = "locationAddress", target = "address")
    @Mapping(source = "locationLng", target = "lng")
    @Mapping(source = "locationLat", target = "lat")
    @Mapping(source = "locationDescription", target = "description")
    @Mapping(constant = "P", target = "status")
    @Mapping(expression = "java(Instant.now())", target = "createdAt")
    @Mapping(constant = "0", target = "averageRating")
    Location toLocation(LocationDto locationDto);


//    @Mapping(source = "id", target = "locationId")
//    @InheritInverseConfiguration(name = "toLocation")
//    LocationInfo toLocationInfoId (Location location);

    @Mapping(source = "id", target = "locationId")
    @Mapping(source = "name", target = "locationName")
    @Mapping(constant = "0", target = "locationAverageRating")
    @Mapping(source = "address", target = "locationAddress")
    @Mapping(source = "locationType.colorCode", target = "typeColorCode")
    @Mapping(source = "county.name", target = "countyName")
    @Mapping(constant = "", target = "locationImageData")
    @Mapping(constant = "false", target = "isInFavourites")
    LocationInfo toLocationInfo(Location location);


    List<LocationInfo> toLocationInfos(List<Location> locations);

}