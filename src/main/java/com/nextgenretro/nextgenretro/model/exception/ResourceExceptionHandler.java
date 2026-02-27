package com.nextgenretro.nextgenretro.model.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound (ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(),request.getRequestURI(),e.getMessage(),error,status.value());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<StandardError> gameNotFound (GameNotFoundException e, HttpServletRequest request){
        String error = "Game  not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(),request.getRequestURI(),e.getMessage(),error,status.value());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(GameFachaEtariaNotFoundException.class)
    public ResponseEntity<StandardError> gameFachaEtariaNotFound (GameFachaEtariaNotFoundException e, HttpServletRequest request){
        String error = "FachaEtaria  not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(),request.getRequestURI(),e.getMessage(),error,status.value());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(GamePriceNotFoundException.class)
    public ResponseEntity<StandardError> gamePriceNotFound (GamePriceNotFoundException e, HttpServletRequest request){
        String error = "Price not found ";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(),request.getRequestURI(),e.getMessage(),error,status.value());
        return ResponseEntity.status(status).body(standardError);
    }

}
