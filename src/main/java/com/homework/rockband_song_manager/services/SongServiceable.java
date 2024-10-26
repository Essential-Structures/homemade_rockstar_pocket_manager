package com.homework.rockband_song_manager.services;

import com.homework.rockband_song_manager.models.DTOs.SongDTO;

import java.util.List;

public interface SongServiceable {

    SongDTO saveSong(SongDTO songToPersist);

    List<SongDTO> getSongsByCriteria(String title, Short yearOfRelease);

    void deleteSongById (Short id);
}
