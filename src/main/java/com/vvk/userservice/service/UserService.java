package com.vvk.userservice.service;

import com.vvk.userservice.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity saveUser(UserEntity userEntity);

    UserEntity updateUser(UserEntity userEntity);

//    List<UserEntity> getAllUser();
//
//    UserEntity getUserById(Integer userId);
//
//    void deleteUserById(Integer userId);
}
