package com.web.service;

import com.web.dto.User;
import com.web.dto.UserResponse;
import com.web.exception.UserNotFoundException;
import com.web.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse saveUser(User user) {
        log.info(" user added into the system");
        User saveData = userRepository.save(user);
        return new UserResponse("Success", " Added into the system - " + saveData.getFirstName() + " " + saveData.getLastName());
    }

    @Override
    public List<User> listAllUser() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new UserNotFoundException(" NO user for the given query ");
        }
        return users;
    }

    @Override
    public UserResponse updateUser(User user) {
        Optional<User> userUpdate = userRepository.findById(user.getUserId());
        if (!userUpdate.isPresent()) {
            return new UserResponse("Failed", "user to be not found in the system");
        }
        User saveOrUpdateUser = userRepository.save(user);
        return new UserResponse("SUCCESS", " user updated - " + saveOrUpdateUser.getLastName() + " " + saveOrUpdateUser.getLastName());
    }

    @Override
    public UserResponse deleteByUserId(Integer id) {
        Optional<User> deleteUser = userRepository.findById(id);
        if (!deleteUser.isPresent()) {
            return new UserResponse("FAILED", "user to be deleted not found in the system");
        }
        userRepository.deleteById(id);
        return new UserResponse("SUCCESS", "Product Deleted");
    }

    @Override
    public User findByUserId(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(" User ot found for id - " + id));
    }

}
