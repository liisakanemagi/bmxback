package ee.valiit.bmxback.service;

import ee.valiit.bmxback.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.bmxback.persistence.user.User;
import ee.valiit.bmxback.persistence.user.UserRepository;
import ee.valiit.bmxback.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.bmxback.persistence.user.User;
import ee.valiit.bmxback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getValidUser(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new PrimaryKeyNotFoundException("useId", userId));

    }

}
