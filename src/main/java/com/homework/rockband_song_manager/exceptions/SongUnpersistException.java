package com.homework.rockband_song_manager.exceptions;

import lombok.Data;

@Data
public class SongUnpersistException extends RuntimeException {

    public SongUnpersistException(String message) {
        super(message);
    }
}
