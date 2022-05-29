package lt.codeacademy.thymeleafprojektas.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.PlaylistRepository;
import lt.codeacademy.thymeleafprojektas.model.Playlist;
import lt.codeacademy.thymeleafprojektas.model.Song;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final SongService songService;

    public Playlist createNewLikedSongPlaylist(){
        Playlist playlist = Playlist.builder().name("Liked Songs").build();
        playlistRepository.save(playlist);
        return playlist;
    }

    @Transactional
    public void addSongToPLaylist(Long songId, Long playlistId){
        Song song = songService.getSongByID(songId);
        Playlist playlist = playlistRepository.getById(playlistId);
        playlist.getSongs().add(song);
        playlistRepository.save(playlist);
    }

}
