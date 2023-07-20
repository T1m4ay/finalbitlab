package com.example.finalproject.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "t_game_genre")
@Entity
@Getter
@Setter
public class Genre {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "g_name")
    private String name;

}
