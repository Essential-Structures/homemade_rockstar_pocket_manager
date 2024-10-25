package com.homework.rockband_song_manager.services;

import com.homework.rockband_song_manager.models.DTOs.SongDTO;

import java.util.List;
import java.util.Optional;

public interface SongServiceable {

    SongDTO saveSong(SongDTO songToPersist);
    List<SongDTO> getSongsByCriteria (Optional<String> title, Optional<Short> yearOfRelease);
}
