package com.example.finalproject.dto;

import com.example.finalproject.model.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameDTO {

    private Long id;
    private String gameName;
    private String description;
    private String author;
    private Genre genre;

}
