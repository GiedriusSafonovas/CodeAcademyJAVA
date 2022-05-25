package lt.codeacademy.thymeleafprojektas.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.AlbumRepository;
import lt.codeacademy.thymeleafprojektas.Repository.AuthorRepository;
import lt.codeacademy.thymeleafprojektas.Repository.SongRepository;
import lt.codeacademy.thymeleafprojektas.dto.SongDtoGet;
import lt.codeacademy.thymeleafprojektas.dto.SongDtoPost;
import lt.codeacademy.thymeleafprojektas.mapper.SongDtoPostToSongMapper;
import lt.codeacademy.thymeleafprojektas.mapper.SongToSongDtoGetMapper;
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
    private final SongToSongDtoGetMapper songToSongDtoGetMapper;
    private final SongDtoPostToSongMapper songDtoPostToSongMapper;

    public void addSong(SongDtoPost songDtoPost) {
        System.out.println(songDtoPost);

        List<Author> authorList = Arrays.stream(songDtoPost.getAuthorString().split(";"))
                .map(authorName -> authorRepository.findAuthorByName(authorName.strip()).orElse(Author.builder().name(authorName.strip()).build()))
                .collect(Collectors.toList());

        List<Album> albumList = Arrays.stream(songDtoPost.getAlbumString().split(";"))
                .map(albumName -> albumRepository.findAlbumByName(albumName.strip()).orElse(Album.builder().name(albumName.strip()).build()))
                .collect(Collectors.toList());

        Song song = Song.builder()
                .songName(songDtoPost.getSongName())
                .playtime(songDtoPost.getPlaytime())
                .albums(albumList)
                .authors(authorList)
                .build();

        System.out.println(song);

        songRepository.save(song);
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Page<SongDtoGet> getSongsPageable(Pageable pageable) {
        return songRepository.findAll(pageable).map(songToSongDtoGetMapper::map);
    }

    public SongDtoGet getSongDtoGetByID(Long id) {
        Song song = songRepository.findById(id).orElseThrow();
        return songToSongDtoGetMapper.map(song);
    }

    @Transactional
    public void updateSong(SongDtoPost songDtoPost, Long id) {
        songDtoPost.setId(id);
        Song songUpdate = songDtoPostToSongMapper.map(songDtoPost);

        Song song = songRepository.getById(id);

        song = song.toBuilder()
                .songName(songUpdate.getSongName())
                .playtime(songUpdate.getPlaytime())
                .albums(songUpdate.getAlbums())
                .authors(songUpdate.getAuthors()).build();

        songRepository.save(song);
    }

    @Transactional
    public void deleteSongById(Long id) {
        songRepository.deleteByIdSongAlbum(id);
        songRepository.deleteByIdSongAuthor(id);
        songRepository.deleteByIdSong(id);
    }
}
