package lt.codeacademy.thymeleafprojektas.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.PlaylistRepository;
import lt.codeacademy.thymeleafprojektas.model.Playlist;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public Playlist createNewLikedSongPlaylist(){
        Playlist playlist = Playlist.builder().name("Liked Songs").build();
        playlistRepository.save(playlist);
        return playlist;
    }

}
