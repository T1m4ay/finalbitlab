package com.example.finalproject.dto;

import com.example.finalproject.model.Genre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDTO {

    private Long id;
    private String gameName;
    private String description;
    private Boolean handled;
    private String author;
    private String genre;


}
