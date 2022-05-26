package lt.codeacademy.thymeleafprojektas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String registrationPageGet(){
        return "userRegistration";
    }
}
