package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.locationtype.dto.LocationTypeInfo;
import ee.valiit.bmxback.persistence.locationtype.LocationTypeMapper;
import ee.valiit.bmxback.persistence.locationtype.LocationTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class LocationTypeService {


    private final LocationTypeRepository locationTypeRepository;
    private final LocationTypeMapper locationTypeMapper;

    public List<LocationTypeInfo> findLocationTypes() {

    }
}
