package com.example.finalproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_game")
@Getter
@Setter
public class Game {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String game;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "handled")
    private Boolean handled;

    @Column(name = "author")
    private String author;

    private String genre;

}
