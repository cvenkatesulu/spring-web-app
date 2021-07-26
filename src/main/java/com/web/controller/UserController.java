package com.web.controller;

import com.web.dto.User;
import com.web.dto.UserResponse;
import com.web.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserResponse> addUser(@RequestBody User user){
        UserResponse userResponse = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

}
