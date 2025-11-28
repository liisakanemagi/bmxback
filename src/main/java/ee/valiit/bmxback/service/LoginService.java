package ee.valiit.bmxback.service;

import ee.valiit.bmxback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class LoginService {

    private final UserRepository userRepository;

    public void login(String username, String password) {
        userRepository.findUserBy(username,password);
    }
}
