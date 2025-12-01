package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.login.dto.LoginResponse;
import ee.valiit.bmxback.infrastructure.error.Error;
import ee.valiit.bmxback.infrastructure.exception.ForbiddenException;
import ee.valiit.bmxback.persistence.user.User;
import ee.valiit.bmxback.persistence.user.UserMapper;
import ee.valiit.bmxback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class LoginService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        User user = userRepository.findActiveUsersBy(username, password)
                .orElseThrow(() -> new ForbiddenException(Error.INCORRECT_CREDENTIALS.getMessage(), Error.INCORRECT_CREDENTIALS.getErrorCode()));

        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;

    }


}
