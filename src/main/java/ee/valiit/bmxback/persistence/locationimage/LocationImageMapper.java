package ee.valiit.bmxback.persistence.locationimage;

import ee.valiit.bmxback.controller.locationimage.dto.LocationImageInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationImageMapper {

    @Mapping(source = "imageData",target = "imageData") //kas source peaks olema constant = ""?
    LocationImage toLocationImage(LocationImageInfo locationImageInfo);

}