package ee.valiit.bmxback.persistence.location;

import ee.valiit.bmxback.controller.location.dto.LocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;

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

}