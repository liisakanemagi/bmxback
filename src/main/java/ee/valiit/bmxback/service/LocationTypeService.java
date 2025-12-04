package ee.valiit.bmxback.service;

import ee.valiit.bmxback.persistence.locationtype.LocationTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class LocationTypeService {


    private final LocationTypeRepository locationTypeRepository;

    public void findLocationTypes(Integer locationTypeId) {
        locationTypeRepository.findLocationTypeInfosBy();
    }
}
