package lt.codeacademy.thymeleafprojektas.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.thymeleafprojektas.Repository.AuthorityRepository;
import lt.codeacademy.thymeleafprojektas.Repository.UserRepository;
import lt.codeacademy.thymeleafprojektas.dto.UserDto;
import lt.codeacademy.thymeleafprojektas.model.Authority;
import lt.codeacademy.thymeleafprojektas.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor

public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public void registerNewUser(UserDto userDto){

        Authority authority = Authority.builder().name("USER").build();

        authorityRepository.save(authority);

        userRepository.save(User.builder()
                .Username(userDto.getUserName())
                .Password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userDto.getPassword()))
                        .authorities(Set.of(authority))
                .build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUsersByUsernameWithAuthorities(username).orElseThrow();
    }
}