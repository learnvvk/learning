package com.vvk.userservice.exception;

import com.vvk.userservice.utils.CommonHttpStatus;

public class ValidationException extends BaseException{

    public ValidationException(String msg, int code){
        super(msg,code, CommonHttpStatus.BAD_REQUEST);
    }
}
