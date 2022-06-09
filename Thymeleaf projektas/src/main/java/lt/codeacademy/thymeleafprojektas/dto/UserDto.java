package lt.codeacademy.thymeleafprojektas.dto;

import lombok.Builder;
import lombok.Data;
import lt.codeacademy.thymeleafprojektas.validation.UniqueUsername;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class UserDto {

    @NotBlank
    @UniqueUsername
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatedPassword;
}
