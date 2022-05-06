package lt.codeacademy.thymeleafprojektas.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.SongRepository;
import lt.codeacademy.thymeleafprojektas.model.Song;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;

    public void addSong(Song song){
        System.out.println(song);
        songRepository.save(song);
    }
}
