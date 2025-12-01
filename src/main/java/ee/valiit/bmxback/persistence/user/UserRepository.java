package ee.valiit.bmxback.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    void findUserBy(String username, String password);

    @Query("select u from User u where u.username = :username and u.password = :password and u.status = 'A'")
    Optional<User> findActiveUsersBy(String username, String password);

    String status(String status);
}
