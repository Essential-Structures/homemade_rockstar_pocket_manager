package com.homework.session23.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@Slf4j
@ControllerAdvice //general exception handler class
public class ExceptionHandleAdvizor {

    private ObjectMapper objectMapper;

    //ObjectMapper dependency injection via constructor
    public ExceptionHandleAdvizor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    //method to handle invalidInputData exceptions
    @ExceptionHandler(InvalidInputDataException.class)
    public ResponseEntity<String> invalidInputDataException(InvalidInputDataException invalidInputDataException) {
        return new ResponseEntity<>(objectToString(Map.of("key",invalidInputDataException.getMessage())), HttpStatus.BAD_REQUEST);
    }

    //convert exception to String, to display
    public String objectToString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.info("Error processing the response object into a string");
            return ("Internal error");
        }


    }
}