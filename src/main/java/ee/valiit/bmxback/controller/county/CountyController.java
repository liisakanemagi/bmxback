package ee.valiit.bmxback.controller.county;
import ee.valiit.bmxback.controller.county.dto.CountyInfo;
import ee.valiit.bmxback.service.CountyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountyController {

    private final CountyService countyService;
    @GetMapping("/counties")
    @Operation(
            summary = "Leiab süsteemist kõik maakonnad.",
            description = "Tagastab kogu county tabeli info")
    public List<CountyInfo> findCounties() {
        return countyService.findCounties();
    }

}
