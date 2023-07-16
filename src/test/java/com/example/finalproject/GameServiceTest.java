package com.example.finalproject;

import com.example.finalproject.dto.GameDTO;
import com.example.finalproject.mapper.GameMapper;
import com.example.finalproject.model.Game;
import com.example.finalproject.repository.GameRepository;
import com.example.finalproject.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GameServiceTest {
    private GameService gameService;

    @Mock
    private GameRepository gameRepository;

    @Mock
    private GameMapper gameMapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        gameService = new GameService(gameRepository, gameMapper);
    }

    @Test
    void getGames_shouldReturnListOfGames() {
        List<Game> gameList = new ArrayList<>();
        Game testGame1 = new Game();
        testGame1.setId(1L);
        testGame1.setGame("Dota");
        Game testGame2 = new Game();
        testGame1.setId(2L);
        testGame1.setGame("CS");
        gameList.add(testGame1);
        gameList.add(testGame2);

        when(gameRepository.findAll()).thenReturn(gameList);

        List<GameDTO> gameDTOList = new ArrayList<>();
        GameDTO testGameDTO1 = new GameDTO();
        testGameDTO1.setId(1L);
        testGameDTO1.setGameName("Dota");
        GameDTO testGameDTO2 = new GameDTO();
        testGameDTO1.setId(2L);
        testGameDTO1.setGameName("CS");
        gameDTOList.add(testGameDTO1);
        gameDTOList.add(testGameDTO2);

        when(gameMapper.toDtoList(gameList)).thenReturn(gameDTOList);

        List<GameDTO> result = gameService.getGames();

        assertEquals(gameDTOList, result);
        verify(gameRepository, times(1)).findAll();
        verifyNoMoreInteractions(gameRepository);
        verify(gameMapper, times(1)).toDtoList(gameList);
        verifyNoMoreInteractions(gameMapper);
    }

    @Test
    void getGame_withExistingId_shouldReturnGame() {
        Long gameId = 1L;

        Game game = new Game();
        game.setId(gameId);
        game.setGame("Terraria");
        when(gameRepository.findById(gameId)).thenReturn(Optional.of(game));

        GameDTO expectedGameDTO = new GameDTO();
        expectedGameDTO.setId(gameId);
        expectedGameDTO.setGameName("Terraria");
        when(gameMapper.toDto(game)).thenReturn(expectedGameDTO);

        GameDTO result = gameService.getGame(gameId);

        assertEquals(expectedGameDTO, result);
        verify(gameRepository, times(1)).findById(gameId);
        verifyNoMoreInteractions(gameRepository);
        verify(gameMapper, times(1)).toDto(game);
        verifyNoMoreInteractions(gameMapper);
    }

    @Test
    void deleteGame_shouldCallDeleteById() {
        Long gameId = 1L;

        gameService.deleteGame(gameId);

        verify(gameRepository, times(1)).deleteById(gameId);
        verifyNoMoreInteractions(gameRepository);
        verifyNoInteractions(gameMapper);
    }
}