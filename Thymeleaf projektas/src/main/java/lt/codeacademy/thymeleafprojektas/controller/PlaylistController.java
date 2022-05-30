package lt.codeacademy.thymeleafprojektas.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.service.PlaylistService;
import lt.codeacademy.thymeleafprojektas.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;
    private final UserService userService;

    @PostMapping("/LikeSong/{songId}")
    public String likeSong(Principal principal, @PathVariable Long songId){

        Long playlistId = userService.getLikedSongPlaylistId(principal.getName());
        playlistService.addSongToPLaylist(songId, playlistId);
        return "redirect:/songs";
    }

}
