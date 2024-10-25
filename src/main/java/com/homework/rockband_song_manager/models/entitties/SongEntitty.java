package com.homework.rockband_song_manager.models.entitties;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Table(name = "song_metadata")
public class SongEntitty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name = "song_name")
    private String name;
    @Column(name="song_composer")
    private String composer;
    @Column(name="year_of_release")
    private LocalDate yearOfRelease;
}
