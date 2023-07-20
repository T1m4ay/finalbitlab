package com.example.finalproject.repository;

import com.example.finalproject.model.Genre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GenreRepository extends JpaRepository<Genre, Long>  {
    Genre findByName(String name);
}
