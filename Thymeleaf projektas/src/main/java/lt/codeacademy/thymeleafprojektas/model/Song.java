package lt.codeacademy.thymeleafprojektas.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Song {
    private String songName;
    private String album;
    private String author;
    private String playtime;
}
