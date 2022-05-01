package lt.codeacademy.thymeleafprojektas.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Song {
    private String songName;
    private String album;
    private String author;
    private String playtime;
}
