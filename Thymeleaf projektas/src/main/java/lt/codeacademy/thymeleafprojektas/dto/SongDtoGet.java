package lt.codeacademy.thymeleafprojektas.dto;

import lombok.Builder;
import lombok.Data;
import lt.codeacademy.thymeleafprojektas.model.Album;
import lt.codeacademy.thymeleafprojektas.model.Author;

import java.util.List;

@Data
@Builder
public class SongDtoGet {

    private Long id;

    private String songName;

    private String playtime;

    private String authorString;

    private String albumString;

    private List<Album> albumList;

    private List<Author> authorList;
}
