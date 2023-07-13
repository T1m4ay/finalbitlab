package com.example.finalproject.mapper;

import com.example.finalproject.dto.GameDTO;
import com.example.finalproject.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper {

    @Mapping(source = "game", target = "gameName")
    GameDTO toDto(Game game);

    @Mapping(source = "gameName", target = "game")
    Game toModel(GameDTO gameDTO);

    List<GameDTO> toDtoList(List<Game> gameList);
    List<Game> toModelList(List<GameDTO> gameDTOList);

}
