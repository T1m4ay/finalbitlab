package com.example.finalproject.mapper;

import com.example.finalproject.dto.GameDTO;
import com.example.finalproject.dto.GenreDTO;
import com.example.finalproject.model.Game;
import com.example.finalproject.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    @Mapping(source = "name", target = "genreName")
    GenreDTO toDto(Genre genre);

    @Mapping(source = "genreName", target = "name")
    Genre toModel(GenreDTO genreDTO);

    List<GenreDTO> toDtoList(List<Genre> genreList);
    List<Genre> toModelList(List<GenreDTO> genreDTOList);

}
