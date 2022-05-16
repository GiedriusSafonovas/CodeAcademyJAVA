package lt.codeacademy.thymeleafprojektas.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.SongRepository;
import lt.codeacademy.thymeleafprojektas.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;

    public void addSong(Song song){
        System.out.println(song);
        songRepository.save(song);
    }

    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    public Page<Song> getSongsPageable(Pageable pageable){
        return songRepository.findAll(pageable);
    }

    public Song getSongByID(Long id){
        return songRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void updateSong(Song song, Long id){
        song.setId(id);
        songRepository.save(song);
    }

    @Transactional
    public void deleteSongById(Long id){
        songRepository.deleteById(id);
    }
}
