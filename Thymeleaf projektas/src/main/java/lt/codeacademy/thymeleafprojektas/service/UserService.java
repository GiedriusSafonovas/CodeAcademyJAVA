package lt.codeacademy.thymeleafprojektas.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.UserRepository;
import lt.codeacademy.thymeleafprojektas.dto.UserDto;
import lt.codeacademy.thymeleafprojektas.model.Users;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void registerNewUser(UserDto userDto){
        userRepository.save(Users.builder()
                .Name(userDto.getUserName())
                .Password(userDto.getPassword())
                .build());
    }
}
