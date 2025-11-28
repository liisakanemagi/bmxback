package ee.valiit.bmxback.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    void findUserBy(String username, String password);
}
//Kutsu kutsu