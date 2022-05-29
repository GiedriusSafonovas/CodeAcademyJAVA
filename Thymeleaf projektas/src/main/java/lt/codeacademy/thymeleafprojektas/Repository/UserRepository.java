package lt.codeacademy.thymeleafprojektas.Repository;

import lt.codeacademy.thymeleafprojektas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT u FROM User u JOIN FETCH u.authorities WHERE u.Username = :userName")
    Optional<User> findUsersByUsernameWithAuthorities(String userName);
}