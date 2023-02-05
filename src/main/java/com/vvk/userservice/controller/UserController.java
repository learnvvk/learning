package com.vvk.userservice.controller;

import com.vvk.userservice.dto.ResponseBO;
import com.vvk.userservice.entity.UserEntity;
import com.vvk.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController extends GenericController{

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<ResponseBO<UserEntity>> saveUser(@RequestBody @Validated UserEntity user){
        UserEntity savedUser = this.userService.saveUser(user);
        return sendResponse(savedUser);
    }

//    @GetMapping("/users/{userId}")
//    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer userId){
//        UserEntity user = this.userService.getUserById(userId);
//        return ResponseEntity.ok(user);
//    }
//
//    @GetMapping("/users")
//    public ResponseEntity<List<UserEntity>> getAllUser(){
//        List<UserEntity> users = this.userService.getAllUser();
//        return ResponseEntity.status(HttpStatus.FOUND).body(users);
//    }
}
