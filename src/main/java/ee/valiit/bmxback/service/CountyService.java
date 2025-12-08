package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.county.dto.CountyInfo;
import ee.valiit.bmxback.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.bmxback.persistence.county.County;
import ee.valiit.bmxback.persistence.county.CountyMapper;
import ee.valiit.bmxback.persistence.county.CountyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountyService {

    private final CountyRepository countyRepository;
    private final CountyMapper countyMapper;

    public List<CountyInfo> findCounties() {
        Sort sort = Sort.by(Sort.DEFAULT_DIRECTION, "name");
        List<County> counties = countyRepository.findAll(sort);
        return countyMapper.toCountyInfos(counties);
    };
    public County getValidCounty(Integer countyId) {
        return countyRepository.findById(countyId).orElseThrow(() -> new PrimaryKeyNotFoundException("countyId", countyId));
    }

public County getValidCounty(Integer countyId){
        return countyRepository.findById(countyId)
            .orElseThrow(() -> new PrimaryKeyNotFoundException("countyId", countyId));
}


}
