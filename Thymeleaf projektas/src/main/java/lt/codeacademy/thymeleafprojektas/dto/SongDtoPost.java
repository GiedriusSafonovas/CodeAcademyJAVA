package lt.codeacademy.thymeleafprojektas.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongDtoPost {

    private Long id;

    private String songName;

    private String playtime;

    private String authorString;

    private String albumString;
}
