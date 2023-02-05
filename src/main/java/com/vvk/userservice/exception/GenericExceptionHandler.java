package com.vvk.userservice.exception;

import com.vvk.userservice.controller.GenericController;
import com.vvk.userservice.dto.ErrorBO;
import com.vvk.userservice.dto.ResponseBO;
import com.vvk.userservice.utils.CommonHttpStatus;
import com.vvk.userservice.utils.ErrorCode;
import com.vvk.userservice.utils.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GenericExceptionHandler {

    private final ErrorBO GENERIC_ERROR =
            new ErrorBO(ErrorMessage.GENERAL_ERROR, String.valueOf(ErrorCode.GENERAL_ERROR));

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBO<Object>> getException(Exception ex, WebRequest request){

        if(ex instanceof BaseException){
            BaseException baseException=(BaseException) ex;
            ErrorBO errorBo = ErrorBO.builder()
                    .errorCode(String.valueOf(baseException.getErrorCode()))
                    .errorMessage(baseException.getMessage())
                    .build();
            return GenericController.sendFailure(null, Arrays.asList(errorBo),baseException.getHttpStatus());
        }

        if (ex instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
            int index = 403001;
            List<ErrorBO> errors = new ArrayList<>();
            for (ObjectError objectError:errorList){
                errors.add(new ErrorBO(objectError.getDefaultMessage(), String.valueOf(index++)));
            }

            return GenericController.sendFailure(null,errors, CommonHttpStatus.BAD_REQUEST);
        }else{

            ErrorBO errorBO = ErrorBO.builder()
                    .errorCode(String.valueOf(String.valueOf(ErrorCode.GENERAL_ERROR)))
                    .errorMessage(ex.getMessage())
                    .build();

            return GenericController.sendFailure(
                    null,Arrays.asList(errorBO),CommonHttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
