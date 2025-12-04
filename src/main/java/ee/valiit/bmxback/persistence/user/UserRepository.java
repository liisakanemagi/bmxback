package ee.valiit.bmxback.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username = :username and u.password = :password and u.status = 'A'")
    Optional<User> findActiveUserBy(String username, String password);

    @Query("select (count(u) > 0) from User u where u.username = :username")
    boolean userExistsBy(String username);


}