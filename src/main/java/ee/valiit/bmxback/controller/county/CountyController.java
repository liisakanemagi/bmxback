package ee.valiit.bmxback.controller.county;

import ee.valiit.bmxback.service.county.CountyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class CountyController {

    private final CountyService countyService;

    @GetMapping("/new-location/county")

    public void findCounties() {
        countyService.findCounties();
    }

}
