package com.web.service;

import com.web.dto.User;
import com.web.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse saveUser(User user);

    List<User> listAllUser();

    UserResponse updateUser(User user);

    UserResponse deleteByUserId(Integer id);

    User findByUserId(Integer id);

}
