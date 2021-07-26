package com.web.service;

import com.web.dto.User;
import com.web.dto.UserResponse;
import com.web.exception.UserNotFoundException;
import com.web.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceimpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse saveUser(User user){
        log.info(" user added into the system");
        User saveData = userRepository.save(user);
        return new UserResponse("Success", " Added into the system - "+saveData.getFirstName()+" "+saveData.getLastName());
    }

    @Override
    public List<User> listAllUser() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()){
            throw new UserNotFoundException(" NO user for thge given query ");
        }
        return users;
    }

    @Override
    public UserResponse updateUser(User user) {
        return null;
    }

    @Override
    public UserResponse deleteByUserId(Integer id) {
        return null;
    }

    @Override
    public User findByUserId(Integer id) {
        return null;
    }


}
