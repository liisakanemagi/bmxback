package ee.valiit.bmxback.controller.register;

import ee.valiit.bmxback.controller.register.dto.UserInfo;
import ee.valiit.bmxback.service.register.RegisterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("/register")

    public void register(@RequestBody @Valid UserInfo userInfo) {
        registerService.register(userInfo);
    }


}
