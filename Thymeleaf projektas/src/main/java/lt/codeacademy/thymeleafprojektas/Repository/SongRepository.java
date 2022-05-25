package lt.codeacademy.thymeleafprojektas.Repository;


import lt.codeacademy.thymeleafprojektas.model.Song;
import org.postgresql.core.NativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Page<Song> findSongBySongNameIsLikeIgnoreCase(String songName, Pageable pageable);

}
