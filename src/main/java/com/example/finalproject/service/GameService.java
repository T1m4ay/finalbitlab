package com.example.finalproject.service;

import com.example.finalproject.dto.GameDTO;
import com.example.finalproject.mapper.GameMapper;
import com.example.finalproject.model.Game;
import com.example.finalproject.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public List<GameDTO> getGames(){
        return gameMapper.toDtoList(gameRepository.findAll());
    }

    public GameDTO addGame(GameDTO game){
        return gameMapper.toDto(gameRepository.save(gameMapper.toModel(game)));
    }

    public GameDTO getGame(Long id){
        return gameMapper.toDto(gameRepository.findById(id).orElse(new Game()));
    }

    public GameDTO updateGame(GameDTO game){
        return gameMapper.toDto(gameRepository.save(gameMapper.toModel(game)));
    }

    public void deleteGame(Long id){
        gameRepository.deleteById(id);
    }
}
