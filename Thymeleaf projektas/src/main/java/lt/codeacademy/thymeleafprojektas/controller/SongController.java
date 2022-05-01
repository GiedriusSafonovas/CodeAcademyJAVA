package lt.codeacademy.thymeleafprojektas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {

    @GetMapping("/addsong")
    public String openAddSongForm(){
        return "addSong";
    }
}
