package lt.codeacademy.thymeleafprojektas.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.service.PlaylistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;

    @PostMapping("/LikeSong/{songId}")
    public String likeSong(Principal principal, @PathVariable Long songId){

        Long playlistId = playlistService.getLikedSongPlaylistId(principal.getName());
        playlistService.addSongToPlaylist(songId, playlistId);
        return "redirect:/songs";
    }

    @PostMapping("/UnLikeSong/{songId}")
    public String unLikeSong(Principal principal, @PathVariable Long songId){

        Long playlistId = playlistService.getLikedSongPlaylistId(principal.getName());
        playlistService.removeSongFromPlaylist(songId, playlistId);
        return "redirect:/songs";
    }

}
