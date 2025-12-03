package ee.valiit.bmxback.controller.register;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class RegisterController {

    @PostMapping("/register")

    public void register() {

    }


}
