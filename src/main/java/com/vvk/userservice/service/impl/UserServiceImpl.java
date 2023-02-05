package com.vvk.userservice.service.impl;

import com.vvk.userservice.entity.UserEntity;
import com.vvk.userservice.repository.UserRepository;
import com.vvk.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

//    @Override
//    public UserEntity getUserById(Integer userId) {
//        return this.userRepository.findById(userId).orElseThrow(
//                ()-> new ResourceNotFoundException("User doest not exit with given Id "+userId));
//    }
//
//    @Override
//    public List<UserEntity> getAllUser() {
//        List<UserEntity> users = this.userRepository.findAll();
//        if(users.isEmpty()){
//            throw new ResourceNotFoundException("Users does n't exist");
//        }
//        return users;
//    }

//    @Override
//    public void deleteUserById(Integer userId) {
//        try {
//            userRepository.deleteById(userId);
//        }catch (Exception e){
//            throw new ResourceNotFoundException("User does not exist with given Id : "+userId);
//        }
//    }
}
