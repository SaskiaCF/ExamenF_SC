package com.mitocode.examenf_sc.exception;


import com.mitocode.examenf_sc.dto.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.Arrays;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse<CustomErrorResponse>> handleDefaultException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse= new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        //return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(new GenericResponse<>(500,"failed", Arrays.asList(errorResponse)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<GenericResponse<CustomErrorResponse>> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        CustomErrorResponse errorResponse= new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new GenericResponse<>(404,"Not Found", Arrays.asList(errorResponse)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<CustomErrorResponse> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        CustomErrorResponse errorResponse= new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse<CustomErrorResponse>> handleBadRequest(MethodArgumentNotValidException ex, WebRequest request) {
        CustomErrorResponse errorResponse= new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new GenericResponse<>(400,"Bad Request", Arrays.asList(errorResponse)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
