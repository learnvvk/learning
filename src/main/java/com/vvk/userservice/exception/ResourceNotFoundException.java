package com.vvk.userservice.exception;

import com.vvk.userservice.utils.CommonHttpStatus;

public class ResourceNotFoundException extends BaseException{

//    public ResourceNotFoundException(){
//        super("Resource not found on Server");
//    }

    public ResourceNotFoundException(String msg, int code){

        super(msg,code, CommonHttpStatus.NOT_FOUND);
    }
}
