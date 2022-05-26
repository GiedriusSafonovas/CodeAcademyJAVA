package lt.codeacademy.thymeleafprojektas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String userName;

    private String password;

    private String repeatedPassword;
}
