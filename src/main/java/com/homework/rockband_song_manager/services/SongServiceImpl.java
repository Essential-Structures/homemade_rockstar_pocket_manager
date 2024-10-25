package com.homework.rockband_song_manager.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.rockband_song_manager.models.DTOs.SongDTO;
import com.homework.rockband_song_manager.models.entitties.SongEntitty;
import com.homework.rockband_song_manager.repository.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SongServiceImpl implements SongServiceable {

    private final SongRepository supository;
    private final ObjectMapper objectMapper;

    public SongServiceImpl(SongRepository supository, ObjectMapper objectMapper) {
        this.supository = supository;
        this.objectMapper = objectMapper;
    }

    @Override
    public SongDTO saveSong(SongDTO songDTOtoPersist) {
        SongEntitty entittyToPersist =
                                objectMapper.convertValue(songDTOtoPersist,SongEntitty.class);
        SongEntitty saved = supository.save(entittyToPersist);
        log.info("We just persisted: {}", saved.toString());
        return objectMapper.convertValue(saved, SongDTO.class);
    }

    @Override
    public List<SongDTO> getSongsByCriteria(Optional<String> title, Optional<Short> yearOfRelease) {
        return List.of();
    }
}
