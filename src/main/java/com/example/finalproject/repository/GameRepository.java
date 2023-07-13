package com.example.finalproject.repository;

import com.example.finalproject.model.Game;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GameRepository extends JpaRepository<Game, Long>  {
}
