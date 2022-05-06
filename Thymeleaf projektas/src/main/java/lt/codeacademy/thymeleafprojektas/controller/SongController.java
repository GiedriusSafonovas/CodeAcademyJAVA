package lt.codeacademy.thymeleafprojektas.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.SongRepository;
import lt.codeacademy.thymeleafprojektas.model.Song;
import lt.codeacademy.thymeleafprojektas.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping("/addsong")
    public String openAddSongForm(Model model){
        model.addAttribute("song", new Song());
        return "addSong";
    }

    @PostMapping("/addsong")
    public String addSong(Model model, Song song){
        songService.addSong(song);
        model.addAttribute("song", new Song());
        return "addSong";
    }

    @GetMapping("/songs")
    public String getSongList(Model model){
        model.addAttribute("songs", songService.getAllSongs());
        return "songs";
    }

    @GetMapping("/songs/update/{id}")
    public String getUpdatableSong(Model model, @PathVariable Long id){
        model.addAttribute("song", songService.getSongByID(id));
        return "addSong";
    }

    @PostMapping("/songs/update/{id}")
    public String updateSong(Model model, Song song, @PathVariable Long id){
        songService.updateSong(song, id);
        model.addAttribute("songs", songService.getAllSongs());
        return "songs";
    }
}
