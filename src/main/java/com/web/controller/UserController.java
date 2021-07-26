package com.web.controller;

import com.web.dto.User;
import com.web.dto.UserResponse;
import com.web.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserResponse> addUser(@RequestBody User user) {
        UserResponse userResponse = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping("/usersList")
    public List<User> getAllUsers() {
        return userService.listAllUser();
    }

    @PutMapping("/updateUser")
    public UserResponse updateUsers(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/findByUser/{id}")
    public User findByUsersId(@PathVariable Integer id) {
        return userService.findByUserId(id);
    }

    @DeleteMapping("/userDelete/{id}")
    public UserResponse deleteUserById(@PathVariable Integer id) {
        return userService.deleteByUserId(id);
    }


}
