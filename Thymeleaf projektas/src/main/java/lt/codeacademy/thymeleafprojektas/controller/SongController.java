package lt.codeacademy.thymeleafprojektas.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.dto.SongDtoGet;
import lt.codeacademy.thymeleafprojektas.dto.SongDtoPost;
import lt.codeacademy.thymeleafprojektas.service.SongService;
import org.springframework.data.domain.Page;
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
        model.addAttribute("song", SongDtoPost.builder().build());
        return "addSong";
    }

    @PostMapping("/addsong")
    public String addSong(SongDtoPost songDtoPost){
        songService.addSong(songDtoPost);
        return "redirect:/addsong";
    }

    @GetMapping("/songs")
    public String getSongList(Model model,
                              @PageableDefault(size = 10, sort = {"songName"}, direction = Sort.Direction.ASC) Pageable pageable){
        Page<SongDtoGet> page = songService.getSongsPageable(pageable);
        model.addAttribute("songPage", page);
        return "songs";
    }

    @GetMapping("/songs/update/{id}")
    public String getUpdatableSong(Model model, @PathVariable Long id){
        model.addAttribute("song", songService.getSongDtoGetByID(id));
        return "addSong";
    }

    @PostMapping("/songs/update/{id}")
    public String updateSong(SongDtoPost song, @PathVariable Long id){
        songService.updateSong(song, id);
        return "redirect:/songs";
    }

    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        songService.deleteSongById(id);
        return "redirect:/songs";
    }
}
