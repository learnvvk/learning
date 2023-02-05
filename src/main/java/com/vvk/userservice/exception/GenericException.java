package com.vvk.userservice.exception;

import com.vvk.userservice.utils.CommonHttpStatus;

public class GenericException extends BaseException{

    public GenericException(String msg, int code){
        super(msg,code, CommonHttpStatus.INTERNAL_SERVER_ERROR);
    }
}
