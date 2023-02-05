package com.vvk.userservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException{

    protected int errorCode;

    public int httpStatus;

    public BaseException(String errorMessage, int errorCode, int httpStatus){

        super(errorMessage);
        this.errorCode=errorCode;
        this.httpStatus=httpStatus;

    }
}
