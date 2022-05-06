package lt.codeacademy.thymeleafprojektas.Repository;


import lt.codeacademy.thymeleafprojektas.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}
