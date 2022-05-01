package lt.codeacademy.thymeleafprojektas.controller;

import lt.codeacademy.thymeleafprojektas.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {

    @GetMapping("/addsong")
    public String openAddSongForm(Model model){
        model.addAttribute("song", new Song());
        return "addSong";
    }
}
