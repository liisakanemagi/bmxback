package ee.valiit.bmxback.persistence.locationimage;

import ee.valiit.bmxback.controller.locationimage.dto.LocationImageDto;
import ee.valiit.bmxback.infrastructure.util.BytesConverter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationImageMapper {


    @Mapping(source = "locationImageData", target = "imageData", qualifiedByName = "toBytes")
    LocationImage toLocationImage(LocationImageDto locationImageDto);

    @Named("toBytes")
    static byte[] toBytes(String value) {
        return BytesConverter.stringToBytes(value);
    }

}



