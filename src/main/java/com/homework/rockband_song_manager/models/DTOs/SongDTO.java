package com.homework.rockband_song_manager.models.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class SongDTO {
    private String title;
    private String composer;
    private Short yearOfRelease;
}
