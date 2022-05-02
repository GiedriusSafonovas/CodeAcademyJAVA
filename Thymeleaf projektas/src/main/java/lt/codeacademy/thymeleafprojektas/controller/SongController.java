package lt.codeacademy.thymeleafprojektas.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.SongRepository;
import lt.codeacademy.thymeleafprojektas.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SongController {

    private final SongRepository songRepository;

    @GetMapping("/addsong")
    public String openAddSongForm(Model model){
        model.addAttribute("song", new Song());
        return "addSong";
    }

    @PostMapping("/addsong")
    public String addSong(Model model, Song song){
        songRepository.addSong(song);
        model.addAttribute("song", new Song());
        return "addSong";
    }

    @GetMapping("/songs")
    public String getSongList(Model model){
        model.addAttribute("songs", songRepository.getAllSongs());
        return "songs";
    }
}
