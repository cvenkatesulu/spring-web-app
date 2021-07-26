package com.web.service;

import com.web.dto.User;
import com.web.dto.UserResponse;
import com.web.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse saveUser(User user){
        log.info(" user added into the system");
        User saveData = userRepository.save(user);
        return new UserResponse("Success", " Added into the system - "+saveData.getFirstName()+" "+saveData.getLastName());
    }



}
