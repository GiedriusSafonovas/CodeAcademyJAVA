package lt.codeacademy.thymeleafprojektas.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.AlbumRepository;
import lt.codeacademy.thymeleafprojektas.Repository.AuthorRepository;
import lt.codeacademy.thymeleafprojektas.Repository.SongRepository;
import lt.codeacademy.thymeleafprojektas.dto.SongDto;
import lt.codeacademy.thymeleafprojektas.model.Album;
import lt.codeacademy.thymeleafprojektas.model.Author;
import lt.codeacademy.thymeleafprojektas.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final AuthorRepository authorRepository;
    private final AlbumRepository albumRepository;

    public void addSong(SongDto songDto){
        System.out.println(songDto);

        List<Author> authorList = Arrays.stream(songDto.getAuthors().split(";"))
                .map(authorName -> authorRepository.findAuthorByName(authorName.strip()).orElse(Author.builder().name(authorName.strip()).build()))
                .collect(Collectors.toList());

        List<Album> albumList = Arrays.stream(songDto.getAlbums().split(";"))
                .map(albumName -> albumRepository.findAlbumByName(albumName.strip()).orElse(Album.builder().name(albumName.strip()).build()))
                .collect(Collectors.toList());

        Song song = Song.builder()
                .songName(songDto.getSongName())
                .playtime(songDto.getPlaytime())
                .albums(albumList)
                .authors(authorList)
                .build();

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
