package com.example.finalproject;

import com.example.finalproject.dto.GameDTO;
import com.example.finalproject.dto.GenreDTO;
import com.example.finalproject.mapper.GameMapper;
import com.example.finalproject.mapper.GenreMapper;
import com.example.finalproject.model.Game;
import com.example.finalproject.model.Genre;
import com.example.finalproject.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class gameTest {

    @Autowired
    private GameMapper gameMapper;
    @Autowired
    private GenreMapper genreMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void checkGameDTO(){

        Game game = new Game();
        game.setId(1L);
        game.setGame("League of Legend");
        game.setDescription("League of Legends is one of the world's most popular video games, developed by Riot Games. It features a team-based competitive game mode based on strategy and outplaying opponents. Players work with their team to break the enemy Nexus before the enemy team breaks theirs.");
        game.setAuthor("Beksulatan Nugmanov");
        game.setGenre("RPG");

        GameDTO gameDTO = gameMapper.toDto(game);

        Assertions.assertEquals(game.getGame(), gameDTO.getGameName());
        Assertions.assertEquals(game.getId(), gameDTO.getId());
        Assertions.assertEquals(game.getAuthor(), gameDTO.getAuthor());
        Assertions.assertEquals(game.getDescription(), gameDTO.getDescription());
        Assertions.assertEquals(game.getHandled(), gameDTO.getHandled());
        Assertions.assertEquals(game.getGenre(), gameDTO.getGenre());
    }

    @Test
    void checkGameModel(){

        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(1L);
        gameDTO.setGameName("League of Legend");
        gameDTO.setDescription("League of Legends is one of the world's most popular video games, developed by Riot Games. It features a team-based competitive game mode based on strategy and outplaying opponents. Players work with their team to break the enemy Nexus before the enemy team breaks theirs.");
        gameDTO.setAuthor("Beksulatan Nugmanov");
        gameDTO.setGenre("RPG");

        Game game = gameMapper.toModel(gameDTO);

        Assertions.assertEquals(gameDTO.getGameName(), game.getGame());
        Assertions.assertEquals(gameDTO.getId(), game.getId());
        Assertions.assertEquals(gameDTO.getAuthor(), game.getAuthor());
        Assertions.assertEquals(gameDTO.getDescription(), game.getDescription());
        Assertions.assertEquals(gameDTO.getHandled(), game.getHandled());
        Assertions.assertEquals(gameDTO.getGenre(), game.getGenre());
    }

    @Test
    void checkGenreDTO(){

        Genre genre = new Genre();
        genre.setId(1L);
        genre.setName("Strategy");

        GenreDTO genreDTO = genreMapper.toDto(genre);

        Assertions.assertEquals(genre.getName(), genreDTO.getGenreName());
        Assertions.assertEquals(genre.getId(), genreDTO.getId());
    }

    @Test
    void checkGenreModel(){

        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(1L);
        genreDTO.setGenreName("Strategy");

        Genre genre = genreMapper.toModel(genreDTO);

        Assertions.assertEquals(genreDTO.getGenreName(), genre.getName());
        Assertions.assertEquals(genreDTO.getId(), genre.getId());
    }



}
