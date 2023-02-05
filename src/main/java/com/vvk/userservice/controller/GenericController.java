package com.vvk.userservice.controller;

import com.vvk.userservice.dto.ErrorBO;
import com.vvk.userservice.dto.ResponseBO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@ControllerAdvice
public class GenericController {

    private static final String SUCCESS = String.valueOf(HttpStatus.OK.value());

    protected <T> ResponseEntity<ResponseBO<T>> sendResponse(T t){
        return new ResponseEntity<>(new ResponseBO<>(t,null,SUCCESS),HttpStatus.OK);
    }

    public static <T> ResponseEntity<ResponseBO<T>> sendFailure(T t, List<ErrorBO> errors, int httpStatus){
        return new ResponseEntity<>(
                new ResponseBO<>(t,errors,String.valueOf(httpStatus)),HttpStatus.resolve(httpStatus));
    }
}
