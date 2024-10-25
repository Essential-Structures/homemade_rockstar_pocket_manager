package com.homework.rockband_song_manager.repository;

import com.homework.rockband_song_manager.models.DTOs.SongDTO;
import com.homework.rockband_song_manager.models.entitties.SongEntitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongEntitty, Byte> , JpaSpecificationExecutor<SongDTO>{}
