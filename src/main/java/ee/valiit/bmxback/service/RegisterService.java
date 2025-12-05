package ee.valiit.bmxback.service;

import ee.valiit.bmxback.controller.register.dto.UserInfo;
import ee.valiit.bmxback.infrastructure.exception.ForbiddenException;
import ee.valiit.bmxback.persistence.role.Role;
import ee.valiit.bmxback.persistence.role.RoleRepository;
import ee.valiit.bmxback.persistence.user.User;
import ee.valiit.bmxback.persistence.user.UserMapper;
import ee.valiit.bmxback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static ee.valiit.bmxback.infrastructure.error.Error.USERNAME_UNAVAILABLE;

@Service
@RequiredArgsConstructor

public class RegisterService {
    public static final String CUSTOMER_ROLE_NAME = "customer";
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public void register(UserInfo userInfo) {
        createAndSaveUser(userInfo);
    }

    private void createAndSaveUser(UserInfo userInfo) {
        User user = createUser(userInfo);
        userRepository.save(user);
    }

    private User createUser(UserInfo userInfo) {
        validateUserNameIsAvailable(userInfo.getUsername());

        Role role = roleRepository.getRoleBy(CUSTOMER_ROLE_NAME);
        User user = userMapper.toUser(userInfo);
        user.setRole(role);
        return user;
    }

    private void validateUserNameIsAvailable(String username) {

        boolean userNameExists = userRepository.userExistsBy(username);
        if (userNameExists) {
            throw new ForbiddenException(USERNAME_UNAVAILABLE.getMessage(), USERNAME_UNAVAILABLE.getErrorCode());
        }
    }


}
