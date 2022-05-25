package lt.codeacademy.thymeleafprojektas.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthorControler {

    private final AuthorService authorService;

    @GetMapping("/author")
    public String getAuthor(){
        return "author";
    }

}
