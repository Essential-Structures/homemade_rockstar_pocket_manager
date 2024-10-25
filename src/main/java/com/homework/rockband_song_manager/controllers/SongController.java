package com.homework.rockband_song_manager.controllers;

import com.homework.rockband_song_manager.models.DTOs.SongDTO;
import com.homework.rockband_song_manager.services.SongServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/songs_api/")
@RestController
public class SongController {

    @Autowired
    private SongServiceable songService;

    @PostMapping
    public ResponseEntity<SongDTO> persistSongsMetadata(@RequestBody SongDTO songToPersist) {
        return new ResponseEntity<> (songService.saveSong(songToPersist), HttpStatus.OK);
    }

    @GetMapping("{songName}")
    public ResponseEntity<SongDTO> retrieveSongByName (@RequestParam
                                                       String songName){
        return ResponseEntity<SongDTO> (songService.retrieveSongByName, HttpStatus.OK)
    }
}
