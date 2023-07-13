package com.example.finalproject.api;

import com.example.finalproject.dto.GameDTO;
import com.example.finalproject.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
@RequiredArgsConstructor
public class GameRestController {

    private final GameService gameService;

    @GetMapping
    public List<GameDTO> gameList(){
        return gameService.getGames();
    }

    @GetMapping(value = "{id}")
    public GameDTO getGame(@PathVariable(name = "id") Long id){
        return gameService.getGame(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public GameDTO addGame(@RequestBody GameDTO game){
        return gameService.addGame(game);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public GameDTO updateGame(@RequestBody GameDTO game){
        return gameService.updateGame(game);
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteGame(@PathVariable(name = "id") Long id){
        gameService.deleteGame(id);
    }

}
