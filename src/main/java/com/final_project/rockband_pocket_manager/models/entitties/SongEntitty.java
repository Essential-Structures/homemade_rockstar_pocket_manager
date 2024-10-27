package com.final_project.rockband_pocket_manager.models.entitties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Table(name = "song_metadata")
public class SongEntitty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "song_name")
    private String name;

    @NotBlank(message = "Composer must be named")
    @Column(name = "song_composer")
    private String composer;

    @NotBlank(message = "Release year must be mentioned")
    @Column(name = "year_of_release")
    private Short yearOfRelease;
}
