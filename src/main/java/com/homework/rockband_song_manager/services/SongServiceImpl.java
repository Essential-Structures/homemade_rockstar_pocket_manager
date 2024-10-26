package com.homework.rockband_song_manager.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.rockband_song_manager.data_filters.SongSpecifictions;
import com.homework.rockband_song_manager.models.DTOs.SongDTO;
import com.homework.rockband_song_manager.models.entitties.SongEntitty;
import com.homework.rockband_song_manager.repository.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SongServiceImpl implements SongServiceable {

    private final SongRepository repository;
    private final ObjectMapper objectMapper;

    public SongServiceImpl(SongRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public SongDTO saveSong(SongDTO songDTOtoPersist) {
        SongEntitty entittyToPersist =
                objectMapper.convertValue(songDTOtoPersist, SongEntitty.class);
        SongEntitty saved = repository.save(entittyToPersist);
        log.info("We just persisted: {}", saved.toString());
        return objectMapper.convertValue(saved, SongDTO.class);
    }

    @Override
    public List<SongDTO> getSongsByCriteria(String title, Short yearOfRelease) {
        Specification<SongEntitty> specs = Specification.
                where(SongSpecifictions.titleSearch(title)).
                and(SongSpecifictions.yearOfReleaseSearch(yearOfRelease));

        List<SongEntitty> songsByCriteria = repository.findAll(specs);
        log.info("Retrieved list of entries from database picked by criteria");

        return songsByCriteria.stream().
                map(songEntitty -> objectMapper.convertValue(songEntitty, SongDTO.class))
                .toList();
    }
}
