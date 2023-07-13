package com.example.finalproject.api;

import com.example.finalproject.dto.GenreDTO;
import com.example.finalproject.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/genre")
@RequiredArgsConstructor
public class GenreRestController {

    private final GenreService genreService;

    @GetMapping
    public List<GenreDTO> genreList(){
        return genreService.getGenres();
    }

    @GetMapping(value = "{id}")
    public GenreDTO getGenre(@PathVariable(name = "id") Long id){
        return genreService.getGenre(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public GenreDTO addGenre(@RequestBody GenreDTO genre){
        return genreService.addGenre(genre);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public GenreDTO updateGenre(@RequestBody GenreDTO genre){
        return genreService.updateGenre(genre);
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteGenre(@PathVariable(name = "id") Long id){
        genreService.deleteGenre(id);
    }


}
