package lt.codeacademy.thymeleafprojektas.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongDto {

    private Long id;

    private String songName;

    private String playtime;

    private String authors;

    private String albums;
}
