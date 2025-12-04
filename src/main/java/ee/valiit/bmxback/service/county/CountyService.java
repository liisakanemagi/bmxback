package ee.valiit.bmxback.service.county;

import ee.valiit.bmxback.persistence.county.County;
import ee.valiit.bmxback.persistence.county.CountyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountyService {

    private final CountyRepository countyRepository;

    public void findCounties() {
        List<County> counties = countyRepository.findAll();

    }

}
