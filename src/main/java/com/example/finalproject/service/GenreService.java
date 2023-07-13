package com.example.finalproject.service;

import com.example.finalproject.dto.GenreDTO;
import com.example.finalproject.mapper.GenreMapper;
import com.example.finalproject.model.Genre;
import com.example.finalproject.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public List<GenreDTO> getGenres(){
        return genreMapper.toDtoList(genreRepository.findAll());
    }

    public GenreDTO addGenre(GenreDTO genre){
        return genreMapper.toDto(genreRepository.save(genreMapper.toModel(genre)));
    }

    public GenreDTO getGenre(Long id){
        return genreMapper.toDto(genreRepository.findById(id).orElse(new Genre()));
    }

    public GenreDTO updateGenre(GenreDTO genre){
        return genreMapper.toDto(genreRepository.save(genreMapper.toModel(genre)));
    }

    public void deleteGenre(Long id){
        genreRepository.deleteById(id);
    }

}
