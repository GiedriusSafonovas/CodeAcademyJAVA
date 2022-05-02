package lt.codeacademy.thymeleafprojektas.Repository;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.model.Song;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository

public class SongRepository {

    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song){
        songs.add(song);
        System.out.println(songs);
    }

    public List<Song> getAllSongs(){
        return songs;
    }
}
