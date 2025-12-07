package ee.valiit.bmxback.persistence.locationimage;

import ee.valiit.bmxback.controller.locationimage.dto.LocationImageInfo;
import ee.valiit.bmxback.infrastructure.util.BytesConverter;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationImageMapper {


    @Mapping(source = "locationImageData", target = "imageData")//kas source peaks olema constant = ""?
    // @Mapping(source = "locationId", target = "location.id")
    LocationImage toLocationImage(LocationImageInfo locationImageInfo);
    LocationImageInfo toLocationImageInfo()
    default byte[] toBytes(String string) {
        return string != null ? string.getBytes() : null;
    }

    @Mapping(source = "", target = "")
}



