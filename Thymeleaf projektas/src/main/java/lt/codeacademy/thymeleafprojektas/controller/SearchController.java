package lt.codeacademy.thymeleafprojektas.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.dto.SongDtoGet;
import lt.codeacademy.thymeleafprojektas.model.Song;
import lt.codeacademy.thymeleafprojektas.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search")
    public String search(@RequestParam String songName){
        return "forward:/search/" + songName;
    }

    @GetMapping("/search/{songName}")
    public String searchResult(Model model, @PathVariable String songName, @PageableDefault(size = 10, sort = {"songName"}, direction = Sort.Direction.ASC) Pageable pageable){
        Page<SongDtoGet> songPage = searchService.searchSongByname(songName, pageable);
        model.addAttribute("songPage", songPage);
        return "songs";
    }


}
