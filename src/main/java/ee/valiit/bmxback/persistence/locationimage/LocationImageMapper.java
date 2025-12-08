package ee.valiit.bmxback.persistence.locationimage;

import ee.valiit.bmxback.controller.locationimage.dto.LocationImageDto;
import ee.valiit.bmxback.infrastructure.util.BytesConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationImageMapper {


    @Mapping(source = "locationImageData", target = "imageData", qualifiedByName = "toBytes")
    LocationImage toLocationImage(LocationImageDto locationImageDto);

    @Named("toBytes")
    static byte[] toBytes(String value) {
        return BytesConverter.stringToBytes(value);
    }

    @Named("bytesToString")
    static String bytesToString(byte[] bytes) {
        return BytesConverter.bytesToString(bytes);
    }


    @Mapping(source = "location.id", target = "locationId")
    @Mapping(source = "imageData", target = "locationImageData", qualifiedByName = "bytesToString")
    LocationImageDto toLocationImageDto(LocationImage locationImage);

    List<LocationImageDto> toLocationImageDtos(List<LocationImage> locationImages);
}
