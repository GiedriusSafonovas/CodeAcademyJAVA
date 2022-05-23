package lt.codeacademy.thymeleafprojektas.Repository;

import lt.codeacademy.thymeleafprojektas.model.Album;
import lt.codeacademy.thymeleafprojektas.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorByNameIsLikeIgnoreCase(String authorName);

}
