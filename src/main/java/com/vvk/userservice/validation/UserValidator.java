package com.vvk.userservice.validation;

import com.vvk.userservice.entity.UserEntity;
import com.vvk.userservice.exception.ResourceNotFoundException;
import com.vvk.userservice.repository.UserRepository;
import com.vvk.userservice.utils.ErrorCode;
import com.vvk.userservice.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    @Autowired
    private UserRepository userRepository;

    public UserEntity validateUser(Integer userId){
        UserEntity user=userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException(
                        ErrorMessage.USER_NOT_EXIST, ErrorCode.USER_NOT_EXIST));

        return user;
    }
}
