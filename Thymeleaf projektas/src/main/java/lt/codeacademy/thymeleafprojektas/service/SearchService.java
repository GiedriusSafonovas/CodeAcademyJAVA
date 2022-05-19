package lt.codeacademy.thymeleafprojektas.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.SongRepository;
import lt.codeacademy.thymeleafprojektas.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SongRepository songRepository;

    public Page<Song> searchSongByname(String songName, Pageable pageable){
        return songRepository.findSongBySongNameIsLikeIgnoreCase(songName, pageable);
    }
}
