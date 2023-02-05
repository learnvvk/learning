package com.vvk.userservice.exception;

import com.vvk.userservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFound
            (ResourceNotFoundException exception){
        String exceptionMessage = exception.getMessage();
        ApiResponse response = ApiResponse.builder()
                .message(exceptionMessage)
                .successStatus(true)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
