package lt.codeacademy.thymeleafprojektas.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.SongRepository;
import lt.codeacademy.thymeleafprojektas.model.Song;
import lt.codeacademy.thymeleafprojektas.service.SongService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public String addSong(Song song){
        songService.addSong(song);
        return "redirect:/addsong";
    }

    @GetMapping("/songs")
    public String getSongList(Model model,
                              @PageableDefault(size = 10) Pageable pageable){
        model.addAttribute("songPage", songService.getSongsPageable(pageable));
        return "songs";
    }

    @GetMapping("/songs/update/{id}")
    public String getUpdatableSong(Model model, @PathVariable Long id){
        model.addAttribute("song", songService.getSongByID(id));
        return "addSong";
    }

    @PostMapping("/songs/update/{id}")
    public String updateSong(Song song, @PathVariable Long id){
        songService.updateSong(song, id);
        return "redirect:/songs";
    }

    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        songService.deleteSongById(id);
        return "redirect:/songs";
    }
}
