package lt.codeacademy.thymeleafprojektas.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.dto.UserDto;
import lt.codeacademy.thymeleafprojektas.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/register")
    public String registrationPageGet(Model model){
        model.addAttribute("userDto", UserDto.builder().build());
        return "userRegistration";
    }

    @PostMapping("/register")
    public String RegisterNewUser(UserDto userDto){
        userService.registerNewUser(userDto);
        return "redirect:/songs";
    }
}
