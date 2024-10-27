package com.final_project.rockband_pocket_manager.exceptions;

import lombok.Data;

@Data
public class SongNotFoundException extends RuntimeException {

    public SongNotFoundException(String message) {
        super(message);
    }
}
