package ee.valiit.bmxback.persistence.county;

import ee.valiit.bmxback.controller.county.dto.CountyInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountyMapper {

    @Mapping(source = "id", target = "countyId")
    @Mapping(source = "name", target = "countyName")
    @Mapping(source = "lng", target = "countyLng")
    @Mapping(source = "lat", target = "countyLat")
    CountyInfo toCountyInfo(County county);

    List<CountyInfo> toCountyInfos(List<County> counties);

}