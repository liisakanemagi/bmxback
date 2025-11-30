package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.LoginResponse;
import ee.valiit.bmxback.infrastructure.exception.ForbiddenException;
import ee.valiit.bmxback.persistence.user.User;
import ee.valiit.bmxback.persistence.user.UserMapper;
import ee.valiit.bmxback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static ee.valiit.bmxback.infrastructure.error.Error.INCORRECT_CREDENTIALS;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        User user = getValidActiveUser(username, password);
        return userMapper.toLoginResponse(user);
    }

    private User getValidActiveUser(String username, String password) {
        return userRepository.findActiveUsersBy(username, password)
                .orElseThrow(() -> new ForbiddenException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode()));
    }
}

